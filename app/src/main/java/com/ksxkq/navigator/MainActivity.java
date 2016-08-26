package com.ksxkq.navigator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ksxkq.navigator.bottombarviewpager.ActivityViewpagerAndBottomBar;
import com.ksxkq.navigator.tabviewpager.ActivityBottomTabViewPager;
import com.ksxkq.navigator.tabviewpager.ActivityTabViewpager;

/**
 * OnePiece
 * Created by xukq on 8/26/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void TabViewpager(View view) {
        Intent intent = new Intent(this, ActivityTabViewpager.class);
        startActivity(intent);
    }

    public void BottomTabViewpager(View view) {
        Intent intent = new Intent(this, ActivityBottomTabViewPager.class);
        startActivity(intent);
    }

    public void BottomBarViewPager(View view) {
        Intent intent = new Intent(this, ActivityViewpagerAndBottomBar.class);
        startActivity(intent);
    }
}
