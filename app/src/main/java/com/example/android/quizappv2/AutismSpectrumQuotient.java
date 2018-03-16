package com.example.android.quizappv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AutismSpectrumQuotient extends AppCompatActivity {
    int i = 0; //index variable to increment through Question and Example String arrays
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autism_spectrum_quotient);

        setToolBar("ASQ Self-Screening");
        customRadioGroup();
    }


    public void updateQuestion() {
        String question[] = getResources().getStringArray(R.array.AutismSpectrumQuestions);
        TextView questionBox = findViewById(R.id.question_box);
        questionBox.setText(question[i]);

    }

    public void checkAnswer(RadioButton button1, RadioButton button2, RadioButton button3, RadioButton button4) {
        String userAnswer = customGetCheckedRadioButton(button1, button2, button3, button4);
        String answers[] = getResources().getStringArray(R.array.AutismSpectrumAnswers);

        if (userAnswer.equals(answers[i - 1])) {
            score++;
        }

    }

    public void setScore() {
        TextView scoreBox = findViewById(R.id.score);
        scoreBox.setText(String.valueOf(score));
    }

    public String customGetCheckedRadioButton(RadioButton button1, RadioButton button2, RadioButton button3, RadioButton button4) {

        if (button1.isChecked()) {
            return button1.getText().toString();
        } else if (button2.isChecked()) {
            return button2.getText().toString();
        } else if (button3.isChecked()) {
            return button3.getText().toString();
        } else {
            return button4.getText().toString();
        }

    }

    public void customRadioGroup() {

        final RadioButton button1, button2, button3, button4;

        Button submit = findViewById(R.id.next_button);

        button1 = findViewById(R.id.strongly_disagree);
        button2 = findViewById(R.id.strongly_agree);
        button3 = findViewById(R.id.slightly_disagree);
        button4 = findViewById(R.id.slightly_agree);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setChecked(false);
                button3.setChecked(false);
                button4.setChecked(false);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setChecked(false);
                button3.setChecked(false);
                button4.setChecked(false);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setChecked(false);
                button2.setChecked(false);
                button4.setChecked(false);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setChecked(false);
                button2.setChecked(false);
                button3.setChecked(false);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                checkAnswer(button1, button2, button3, button4);
                updateQuestion();
                setScore();


                button1.setChecked(false);
                button2.setChecked(false);
                button3.setChecked(false);
                button4.setChecked(false);
            }
        });

    }

    public void setToolBar(String screenTitle) {
        TextView title = findViewById(R.id.title_textview);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle(screenTitle);
        setSupportActionBar(toolbar);
        title.setText(toolbar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
