package com.test.fragment.fragmenttabhost.activity;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.fragment.fragmenttabhost.R;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;
    private String mFragmentTabs[] = {
            "首页",
            "提醒",
            "工作",
            "我的"
    };
    private int mImageSrcs[] = {
            
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
