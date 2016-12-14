package com.test.fragment.fragmenttabhost.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.fragment.fragmenttabhost.R;
import com.test.fragment.fragmenttabhost.adapter.RemindMainAdapter;

import java.util.ArrayList;


public class RemindFragment extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    static ArrayList<String> tabs = new ArrayList<>();

    static {
        tabs.add("第一");
        tabs.add("第二");
        tabs.add("第三");
        tabs.add("第四");
    }
    private ArrayList<Fragment> fragments = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remind, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.remind_tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.remind_viewpager);
        fragments.add(new RemindOneFragment());
        fragments.add(new RemindTwoFragment());
        fragments.add(new RemindThreeFragment());
        fragments.add(new RemindFourFragment());
        RemindMainAdapter adapter = new RemindMainAdapter(getChildFragmentManager(), getActivity(), fragments, tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
