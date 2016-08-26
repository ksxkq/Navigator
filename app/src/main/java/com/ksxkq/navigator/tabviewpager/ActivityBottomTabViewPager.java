package com.ksxkq.navigator.tabviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ksxkq.navigator.bottombarviewpager.MainTabFragment;
import com.ksxkq.navigator.R;
import com.ksxkq.navigator.adapter.ViewPagerFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * OnePiece
 * Created by xukq on 8/26/16.
 */
public class ActivityBottomTabViewPager extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab_viewpager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        // 去掉底部的 indicator
        mTabLayout.setSelectedTabIndicatorHeight(0);
        initViewpager();
        initTabs();
    }

    private void initViewpager() {
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("体育");
        titles.add("巴萨");
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(MainTabFragment.newInstance("tab " + i));
        }
        ViewPagerFragmentAdapter pagerFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(pagerFragmentAdapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initTabs() {
        TabLayout.Tab one = mTabLayout.getTabAt(0);
        TabLayout.Tab two = mTabLayout.getTabAt(1);
        TabLayout.Tab three = mTabLayout.getTabAt(2);

        one.setIcon(R.drawable.ic_accessibility_black_24dp);
        two.setIcon(R.drawable.ic_accessibility_black_24dp);
        three.setIcon(R.drawable.ic_accessibility_black_24dp);
    }
}
