package com.ksxkq.navigator.bottombarviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ksxkq.navigator.R;

/**
 * OnePiece
 * Created by xukq on 8/26/16.
 */
public class ViewPagerChildTextFragment extends Fragment {

    public static final String TAG = ViewPagerChildTextFragment.class.getSimpleName();

    public static ViewPagerChildTextFragment newInstance(String tab) {
        Bundle args = new Bundle();
        args.putString("tab", tab);
        ViewPagerChildTextFragment fragment = new ViewPagerChildTextFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView;
        String tab = (String) getArguments().get("tab");
        convertView = inflater.inflate(R.layout.fragment_test, container, false);
        TextView textView = (TextView) convertView.findViewById(R.id.test_tv);
        if (textView != null) {
            textView.setText(tab);
        }
        return convertView;
    }
}