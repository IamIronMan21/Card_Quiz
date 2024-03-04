package com.example.cardquizgame_haquee1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Buttons for different actions
    private Button button; // Button for registration
    private Button button2; // Button for login
    private Button buttonRules; // Button for rules

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons by finding them in the layout
        button = findViewById(R.id.btn_register);
        button2 = findViewById(R.id.btn_login);
        buttonRules = findViewById(R.id.btn_rules);

        // Set up click listener for registration button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the RegistrationActivity when the registration button is clicked
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

        // Set up click listener for login button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the LoginActivity when the login button is clicked
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        // Set up click listener for rules button
        buttonRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the rules activity when the rules button is clicked
                startActivity(new Intent(MainActivity.this, rules.class));
            }
        });
    }
}
