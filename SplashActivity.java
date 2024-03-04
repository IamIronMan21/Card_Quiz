package com.example.cardquizgame_haquee1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    // UI elements
    private ImageView imageView;
    private TextView textView;
    private Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Log.d("SplashActivity", "onCreate");  // Log statement for debugging

        // Initialize UI elements
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        startGameButton = findViewById(R.id.startGameButton);

        // Set up click listener for the start game button
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to navigate to the MainActivity
                navigateToMainActivity();
            }
        });
    }

    // Method to navigate to the MainActivity
    private void navigateToMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();  // Finish the current activity to remove it from the stack
    }
}