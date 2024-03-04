package com.example.cardquizgame_haquee1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // UI elements
    private EditText emailLi, passwordLi;
    private Button loginButton;

    // SharedPreferences instance to store user data
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI elements
        emailLi = findViewById(R.id.emailEtv);
        passwordLi = findViewById(R.id.passwordEtv);
        loginButton = findViewById(R.id.sendLoginBtn);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("quizPreferences", MODE_PRIVATE);

        // Set up login functionality
        setUpLogin();
    }

    private void setUpLogin() {
        // Set up login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get values from EditTexts
                String email = emailLi.getText().toString();
                String password = passwordLi.getText().toString();

                // Perform login validation
                boolean isValid = validateLogin(email, password);

                if (isValid) {
                    // If login is successful, save the user's email in SharedPreferences
                    saveUserEmail(email);

                    // Display a success message
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();

                    // Navigate to QuestionsActivity
                    Intent intent = new Intent(LoginActivity.this, QuestionsActivity.class);
                    startActivity(intent);
                    finish(); // Finish the current activity
                } else {
                    // Display a failure message for invalid input
                    Toast.makeText(getApplicationContext(), "Login failed. Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateLogin(String email, String password) {
        // Check if both email and password are non-empty
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            return false;
        }

        // Check if email contains '@'
        if (!email.contains("@")) {
            return false;
        }

        // The login is considered valid if all conditions pass
        return true;
    }

    private void saveUserEmail(String email) {
        // Save the user's email in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userEmail", email);
        editor.apply();
    }
}
