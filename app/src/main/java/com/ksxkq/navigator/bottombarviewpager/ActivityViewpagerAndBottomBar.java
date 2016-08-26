package com.ksxkq.navigator.bottombarviewpager;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.aspsine.fragmentnavigator.FragmentNavigator;
import com.aspsine.fragmentnavigator.FragmentNavigatorAdapter;
import com.ksxkq.navigator.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ActivityViewpagerAndBottomBar extends AppCompatActivity {

    // https://github.com/roughike/BottomBar

    private static final int DEFAULT_POSITION = 0;
    private FragmentNavigator mNavigator;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragmentNav(savedInstanceState);
        initBottomNav();
    }

    private void initFragmentNav(Bundle savedInstanceState) {
        mNavigator = new FragmentNavigator(getSupportFragmentManager(), new FragmentAdapter(), R.id.container);
        mNavigator.setDefaultPosition(DEFAULT_POSITION);
        mNavigator.onCreate(savedInstanceState);
        mNavigator.showFragment(DEFAULT_POSITION);
    }

    private void initBottomNav() {
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {
                    mNavigator.showFragment(0);
                } else if (tabId == R.id.tab_nearby) {
                    mNavigator.showFragment(1);
                } else if (tabId == R.id.tab_friends) {
                    mNavigator.showFragment(2);
                }
//                mBottomBar.getCurrentTab().removeBadge();
            }
        });
//        BottomBarTab nearby = mBottomBar.getTabWithId(R.id.tab_nearby);
//        nearby.setBadgeCount(5);
    }

    public class FragmentAdapter implements FragmentNavigatorAdapter {

        public final String[] TABS = {"Friends", "Groups", "Official"};

        @Override
        public Fragment onCreateFragment(int position) {
            return MainTabFragment.newInstance(TABS[position]);
        }

        @Override
        public String getTag(int position) {
            return MainTabFragment.TAG + TABS[position];
        }

        @Override
        public int getCount() {
            return TABS.length;
        }

    }
}
