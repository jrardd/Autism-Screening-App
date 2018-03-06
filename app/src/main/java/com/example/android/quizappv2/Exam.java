package com.example.android.quizappv2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
    }


    public void startExam(View view){
        Intent i = new Intent(this, ExamQuestions.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        finish();
    }
}
