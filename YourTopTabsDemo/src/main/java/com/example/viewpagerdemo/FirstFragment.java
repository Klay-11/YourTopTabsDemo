package com.example.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 模块名-类名
 *
 * @author
 * @date 2018/5/7
 * @备注:
 */
public class FirstFragment extends android.support.v4.app.Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_first, container, false);
        return view;
    }
}
