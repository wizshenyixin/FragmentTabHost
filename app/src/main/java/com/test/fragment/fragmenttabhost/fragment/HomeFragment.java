package com.test.fragment.fragmenttabhost.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.test.fragment.fragmenttabhost.R;
import com.test.fragment.fragmenttabhost.adapter.HomeFirstAdapter;
import com.test.fragment.fragmenttabhost.adapter.HomeTwoAdapter;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;


public class HomeFragment extends Fragment {
    private ViewPager mFirstViewPager;
    private ViewPager mSecondViewPager;
    private View mMainView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("aaa", "onCreateView");
        mMainView = inflater.inflate(R.layout.fragment_home, container, false);
        initFirstViewPager();
        return mMainView;
    }

    private void initFirstViewPager() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(R.mipmap.bg);
        ids.add(R.mipmap.bg);
        mFirstViewPager = (ViewPager) mMainView.findViewById(R.id.home_first_viewPager);
        mFirstViewPager.setPageMargin(20);
        HomeFirstAdapter adapter = new HomeFirstAdapter(getActivity(), ids);
        mFirstViewPager.setAdapter(adapter);
        ArrayList<Integer> secondIds = new ArrayList<>();
        secondIds.add(R.mipmap.bg);
        secondIds.add(R.mipmap.bg);
        secondIds.add(R.mipmap.bg);
        secondIds.add(R.mipmap.bg);
        mSecondViewPager = (ViewPager) mMainView.findViewById(R.id.home_sec_viewPager);
        mSecondViewPager.setPageMargin(30);
        HomeTwoAdapter homeTwoAdapter = new HomeTwoAdapter(getActivity(), secondIds);
        mSecondViewPager.setAdapter(homeTwoAdapter);
        LinearLayout linearLayout = (LinearLayout) mMainView.findViewById(R.id.home_xiaoDian);
        final ImageView imageViews[] = new ImageView[secondIds.size()];
        for (int i = 0; i < secondIds.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(R.drawable.selector_xiaodian);
            LinearLayout.LayoutParams layoutparams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutparams.rightMargin = 30;
            imageView.setLayoutParams(layoutparams);
            if(i==0){
                imageView.setEnabled(true);
            }else{
                imageView.setEnabled(false);
            }
            imageViews[i] = imageView;
            linearLayout.addView(imageView);
        }

        ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < imageViews.length; i++) {
                    if (position == i) {
                        imageViews[i].setEnabled(true);
                    } else {
                        imageViews[i].setEnabled(false);
                    }
                }
//                pagerChange(position, imageViews);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        mSecondViewPager.addOnPageChangeListener(listener);
    }

    private int currentPos = 0;
    private void pagerChange(int position, ImageView imageViews[]) {
        imageViews[position].setEnabled(true);
        imageViews[currentPos].setEnabled(false);
        currentPos = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("aaa", "onSaveInstanceState");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("aaa", "OnResume");
    }
}
