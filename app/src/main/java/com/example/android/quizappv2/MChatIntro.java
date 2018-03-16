package com.example.android.quizappv2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MChatIntro extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_chat_intro);

        setToolBar("M-CHAT/R Screening");

    }


    public void startExam(View view){
        Intent i = new Intent(this, MChatR.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        finish();
    }

    public void setToolBar(String screenTitle){
        TextView title = findViewById(R.id.title_textview);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle(screenTitle);
        setSupportActionBar(toolbar);
        title.setText(toolbar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
