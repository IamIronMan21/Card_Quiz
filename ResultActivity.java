package com.example.cardquizgame_haquee1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    // TextViews to display results
    TextView tv, tv2, tv3;

    // Buttons for restarting the quiz and viewing history
    Button btnRestart, btnHistory;

    // SharedPreferences instance to store and retrieve data
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize TextViews and Buttons by finding them in the layout
        tv = findViewById(R.id.tvres);
        tv2 = findViewById(R.id.tvres2);
        tv3 = findViewById(R.id.tvres3);
        btnRestart = findViewById(R.id.btnRestart);
        btnHistory = findViewById(R.id.btnHistory);

        // Initialize SharedPreferences with the specified name "quizPreferences"
        sharedPreferences = getSharedPreferences("quizPreferences", MODE_PRIVATE);

        // Display quiz results in TextViews
        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + QuestionsActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + QuestionsActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + QuestionsActivity.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        // Store the current score in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastScore", QuestionsActivity.correct);

        // Retrieve user email from SharedPreferences
        String userEmail = sharedPreferences.getString("userEmail", "");
        // If user email is not saved, use a default value
        if (userEmail.equals("")) {
            userEmail = "Unknown User";
        }

        // Save user email in SharedPreferences
        editor.putString("userEmail", userEmail);

        // Increment the history count
        int historyCount = sharedPreferences.getInt("historyCount", 0);
        historyCount++;
        editor.putInt("historyCount", historyCount);

        // Save the current score as "score_historyCount"
        editor.putInt("score_" + historyCount, QuestionsActivity.correct);

        // Apply changes
        editor.apply();

        // Reset quiz scores
        QuestionsActivity.correct = 0;
        QuestionsActivity.wrong = 0;

        // Set up click listener for the Restart button
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restart the quiz by navigating to MainActivity
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });

        // Set up click listener for the History button
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open HistoryActivity to view quiz history
                Intent historyIntent = new Intent(ResultActivity.this, history.class);
                startActivity(historyIntent);
            }
        });
    }
}
