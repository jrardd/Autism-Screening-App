package com.example.android.quizappv2;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class ExampleWindow extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_window);
        setExampleText();
        setDimensions();
    }

    public void setExampleText(){
        Bundle b = getIntent().getExtras();
        String text = b.getString("exampleText");
        TextView exampleBox = findViewById(R.id.example_text);
        exampleBox.setText(text);
    }

    public void setDimensions(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8), (int)(height*0.6));
    }

    public void close(View view){
        finish();
    }


}
