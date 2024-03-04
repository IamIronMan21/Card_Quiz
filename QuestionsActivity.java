package com.example.cardquizgame_haquee1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    // Array to store questions, correct answers, and options
    String questions[] = {
            "What does XML stand for in the context of Android development?",
            "In Android, what is the purpose of the findViewById method?",
            "Which file in Android is used for app configuration and permissions?",
            "What is an APK in Android?",
            "What is the purpose of the Intent in Android?",
    };
    String answers[] = {"Extensible Markup Language","Finding a view by its identifier","AndroidManifest.xml","Android Package Kit","To represent a task to be performed"};
    String opt[ ] = {
            "Extensible Markup Language","Extra Mobile Language","Android Markup Language","Extensive Mobile Language",
            "Finding a view by its identifier","Finding a file by its name","Finding a font by its style","I don't know",
            "AndroidManifest.xml","app_config.txt","permissions.xml","configuration.properties",
            "Android Package Kit","Android Program Kit"," I don't know","Android Processing Kernel",
            "To schedule periodic tasks","To represent a task to be performed","To schedule periodic tasks","To define the layout of an activity",
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        // Initialize UI elements
        final TextView score = (TextView)findViewById(R.id.textView4);
        Intent intent = getIntent();
        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);
        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);

        // Set the first question and options
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if a radio button is selected
                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get the selected radio button and its text
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                // Check if the selected answer is correct and update the score
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                // Update the displayed score
                if (score != null)
                    score.setText(""+correct);

                // Display the next question and options if available, else go to the result activity
                if(flag<questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                } else {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck(); // Clear the selected radio button
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to the result activity when the quit button is clicked
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}