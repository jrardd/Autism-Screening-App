package com.example.android.quizappv2;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ExamViewPager extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_view_pager);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyAdapter());

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

    public class MyAdapter extends PagerAdapter{
        LayoutInflater layoutInflater;
        int[] layouts={R.layout.one,R.layout.two,R.layout.three};

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == (LinearLayout)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View one = layoutInflater.inflate(R.layout.one, container, false);
            View two = layoutInflater.inflate(R.layout.two, container, false);
            View three = layoutInflater.inflate(R.layout.three, container, false);
            View viewarr[] = {one, two, three};
            container.addView(viewarr[position]);
            return viewarr[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);
        }
    }
}
