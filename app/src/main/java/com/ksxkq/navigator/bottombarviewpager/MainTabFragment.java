package com.ksxkq.navigator.bottombarviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ksxkq.navigator.R;
import com.ksxkq.navigator.adapter.ViewPagerFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * OnePiece
 * Created by xukq on 8/26/16.
 */
public class MainTabFragment extends Fragment {
    public static final String TAG = MainTabFragment.class.getSimpleName();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public static MainTabFragment newInstance(String tab) {
        Bundle args = new Bundle();
        args.putString("tab", tab);
        MainTabFragment fragment = new MainTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView;
        String tab = (String) getArguments().get("tab");
        switch (tab) {
            case "Friends":
                convertView = inflater.inflate(R.layout.fragment_viewpager, container, false);
                initViewPager(convertView);
                break;
            case "Groups":
                convertView = inflater.inflate(R.layout.fragment_test, container, false);
                break;
            default:
                convertView = inflater.inflate(R.layout.fragment_test, container, false);
                break;
        }
        TextView textView = (TextView) convertView.findViewById(R.id.test_tv);
        if (textView != null) {
            textView.setText(tab);
        }
        return convertView;
    }

    private void initViewPager(View convertView) {
        mTabLayout = (TabLayout) convertView.findViewById(R.id.tabs);
        mViewPager = (ViewPager) convertView.findViewById(R.id.viewpager);
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("体育");
        titles.add("巴萨");
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(MainTabFragment.newInstance("tab "+i));
        }
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getChildFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
