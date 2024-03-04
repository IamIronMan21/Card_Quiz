package com.example.cardquizgame_haquee1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class history extends AppCompatActivity {

    // SharedPreferences to store and retrieve data
    SharedPreferences sharedPreferences;

    // TextViews to display user information and scores
    TextView tv, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Initialize SharedPreferences with the specified name "quizPreferences"
        sharedPreferences = getSharedPreferences("quizPreferences", MODE_PRIVATE);

        // Initialize TextViews by finding them in the layout
        tv = findViewById(R.id.tvHistory);
        tv2 = findViewById(R.id.tvHistory2);
        tv3 = findViewById(R.id.tvHistory3);

        // Retrieve values passed from ResultActivity
        // User email and history count are retrieved from SharedPreferences
        String userEmail = sharedPreferences.getString("userEmail", "");
        int historyCount = sharedPreferences.getInt("historyCount", 0);

        // Display user email in the first TextView
        tv.setText("User: " + userEmail);

        // Display all scores for the user in the second TextView
        StringBuilder scoresText = new StringBuilder();
        for (int i = 1; i <= historyCount; i++) {
            // Retrieve each score stored with a unique key and append to the StringBuilder
            int score = sharedPreferences.getInt("score_" + i, 0);
            scoresText.append("Test ").append(i).append(": ").append(score).append("\n");
        }
        // Set the text in the second TextView with the concatenated scores
        tv2.setText(scoresText.toString());
    }
}