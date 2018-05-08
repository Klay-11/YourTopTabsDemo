package com.example.viewpagerdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private LinearLayout jxLayout;
    private LinearLayout zxLayout;
    private TextView jx;
    private TextView zx;
    private TextView jxLine;
    private TextView zxLine;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        viewPager = (ViewPager)findViewById(R.id.myviewpager);
        jxLayout = (LinearLayout)findViewById(R.id.jx_layout);
        zxLayout = (LinearLayout)findViewById(R.id.zx_layout);
        jx = (TextView)findViewById(R.id.jx);
        zx = (TextView)findViewById(R.id.zx);
        jxLine = (TextView)findViewById(R.id.jx_line);
        zxLine = (TextView)findViewById(R.id.zx_line);

        viewPager.setOnPageChangeListener(this);
        jxLayout.setOnClickListener(this);
        zxLayout.setOnClickListener(this);

        fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new FirstFragment());

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        resetColor();
        //初始设置选中第一个
        select(0);
    }

    //重置所有颜色
    public void resetColor(){
        jx.setTextColor(Color.BLACK);
        zx.setTextColor(Color.BLACK);
        jxLine.setVisibility(View.INVISIBLE);
        zxLine.setVisibility(View.INVISIBLE);
    }

    //更新选中状态
    public void select(int position){
        viewPager.setCurrentItem(position);
        if(position == 0){
            jx.setTextColor(getResources().getColor(R.color.colorAccent));
            zx.setTextColor(Color.BLACK);
            jxLine.setVisibility(View.VISIBLE);
            zxLine.setVisibility(View.INVISIBLE);
        }else if(position == 1){
            jx.setTextColor(Color.BLACK);
            zx.setTextColor(getResources().getColor(R.color.colorAccent));
            jxLine.setVisibility(View.INVISIBLE);
            zxLine.setVisibility(View.VISIBLE);
        }
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.jx_layout:
                select(0);
                break;
            case R.id.zx_layout:
                select(1);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==0){
            select(0);
        }else {
            select(1);
        }

    }

}