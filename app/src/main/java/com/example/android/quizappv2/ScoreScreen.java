package com.example.android.quizappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_screen);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

        TextView scoreBox = findViewById(R.id.score);
        TextView riskBox = findViewById(R.id.risk);
        TextView description = findViewById(R.id.description);
        Button home = findViewById(R.id.home_button);

        scoreBox.setText("Score: " + score);
        displayRisk(score, riskBox, description);

    }

    public void displayRisk(int score, TextView riskBox, TextView description) {
        if (score <= 2) {
            riskBox.setText("A score of " + score + " indicates low-risk");
            description.setTextSize(18);
            description.setText(R.string.low_risk_description);
        }

        else if(score > 2 && score <= 7) {
            riskBox.setText("A score of " + score + " indicates medium-risk");
            description.setText(R.string.medium_risk_description);
            description.setTextSize(13);
        }

        else {
            riskBox.setText("A score of " + score + " indicates high-risk");
            description.setText(R.string.high_risk_description);
            description.setTextSize(18);
        }


    }

    public void homeButton(View view){
        finish();
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);

    }
}
