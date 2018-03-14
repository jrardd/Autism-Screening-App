package com.example.android.quizappv2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ExamQuestions extends AppCompatActivity {
    int i = 0; //index variable to increment through Question and Example String arrays
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_questions);


    }

    public void exampleButton(View view) {
        Intent intent = new Intent(ExamQuestions.this, ExampleWindow.class);
        updateExample(intent);
        startActivity(intent);
    }

    public void updateExample(Intent intent) {
        String exampleArray[] = getResources().getStringArray(R.array.Examples);
        String currentExample = exampleArray[i];
        intent.putExtra("exampleText", currentExample);
    }


    public void nextButton(View view) {
        RadioGroup choices = findViewById(R.id.radio_group);

        if (choices.getCheckedRadioButtonId() == -1) {
            displayWarningToast();
        } else {
            i++;
            if (i == 20) {
                updateProgressBar();
                checkAnswer();
                toScoreScreen();
            } else {
                checkAnswer();
                updateQuestion();
                updateProgressBar();
                choices.clearCheck();
            }
        }
    }

    public void checkAnswer() {
        RadioButton yesButton = findViewById(R.id.yes_button);

        if (i == 2 | i == 5 | i == 12) {
            if (yesButton.isChecked()) {
                score++;
            } else {
                return;
            }
        } else {
            if (yesButton.isChecked()) {
                return;
            } else {
                score++;
            }
        }


    }


    public void updateQuestion() {
        String questionArray[] = getResources().getStringArray(R.array.Questions);
        TextView questionBox = findViewById(R.id.question_box);
        TextView text = findViewById(R.id.progress_bar_text);
        String num = String.valueOf((i + 1));
        questionBox.setText(questionArray[i]);
        text.setText(num + " of 20");
    }

    public void updateProgressBar() {
        ProgressBar bar = findViewById(R.id.progress_bar);
        ProgressBar completeBar = findViewById(R.id.progress_bar_indeterminate);
        bar.incrementProgressBy(1);
        if(bar.getProgress() == 20){
            bar.setAlpha(0);
            completeBar.setAlpha(1);
        }

    }

    public void updateScore() {
        TextView scoreBox = findViewById(R.id.score);
        String scoreText = String.valueOf(score);
        scoreBox.setText("Score: " + scoreText);
    }

    public void displayWarningToast() {
        LayoutInflater myInflater = LayoutInflater.from(this);
        View view = myInflater.inflate(R.layout.toast_message, (ViewGroup) findViewById(R.id.toast_root));
        Toast warning = new Toast(this);
        warning.setView(view);
        warning.setGravity(Gravity.CENTER, 0, 0);
        warning.setDuration(Toast.LENGTH_SHORT);
        warning.show();
    }

    public void toScoreScreen() {

        new Handler().postDelayed(new Runnable() {
            @Override
                    public void run(){
                Intent i = new Intent(ExamQuestions.this, ScoreScreen.class);
                i.putExtra("score", score);
                startActivity(i);
                overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                finish();
            }
        }, 3000);


    }

}
