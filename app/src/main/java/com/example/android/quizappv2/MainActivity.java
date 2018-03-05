package com.example.android.quizappv2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button toddlerButton, manButton, mapButton, mailButton, infoButton, hubButton;
    private TextView toddlerLabel, manLabel, mapLabel, mailLabel, infoLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define buttons

        toddlerButton = findViewById(R.id.toddler);
        manButton = findViewById(R.id.man);
        mapButton = findViewById(R.id.map);
        infoButton = findViewById(R.id.jigsaw);
        mailButton = findViewById(R.id.mail);
        hubButton = findViewById(R.id.hub);

        //add click listener

        toddlerButton.setOnClickListener(this);
        manButton.setOnClickListener(this);
        mapButton.setOnClickListener(this);
        infoButton.setOnClickListener(this);
        mailButton.setOnClickListener(this);
        // hubButton.setOnClickListener(this);

        //define labels

        toddlerLabel = findViewById(R.id.toddler_label);
        manLabel = findViewById(R.id.man_label);
        mapLabel = findViewById(R.id.map_label);
        mailLabel = findViewById(R.id.mail_label);
        infoLabel = findViewById(R.id.jigsaw_label);

        //add touch listener to transform labels

        hubButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    toddlerLabel.animate().alpha(1.0f);
                    manLabel.animate().alpha(1.0f);
                    mapLabel.animate().alpha(1.0f);
                    infoLabel.animate().alpha(1.0f);
                    mailLabel.animate().alpha(1.0f);
                    hubButton.setBackgroundResource(R.drawable.icon_hub_pressed);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    toddlerLabel.animate().alpha(0.0f);
                    manLabel.animate().alpha(0.0f);
                    mapLabel.animate().alpha(0.0f);
                    infoLabel.animate().alpha(0.0f);
                    mailLabel.animate().alpha(0.0f);
                    hubButton.setBackgroundResource(R.drawable.icon_hub);

                }
                return true;
            }

        });
    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.toddler:
                i = new Intent(this, Exam.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                break;

            case R.id.man:
                i = new Intent(this, Contact.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                break;

            case R.id.map:
                i = new Intent(this, Locate.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                break;

            case R.id.jigsaw:
                i = new Intent(this, Info.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                break;

            case R.id.mail:
                i = new Intent(this, Contact.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                break;


            default:
                break;
        }
    }


}





