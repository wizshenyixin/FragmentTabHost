package com.test.fragment.fragmenttabhost.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class RemindMainAdapter extends FragmentPagerAdapter {
    private ArrayList<String> tabs = new ArrayList<>();
    private Context context;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public RemindMainAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments, ArrayList<String> tabs) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
        this.tabs = tabs;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }

}
