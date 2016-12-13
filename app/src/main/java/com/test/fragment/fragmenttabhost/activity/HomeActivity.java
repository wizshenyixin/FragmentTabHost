package com.test.fragment.fragmenttabhost.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.test.fragment.fragmenttabhost.R;
import com.test.fragment.fragmenttabhost.fragment.HomeFragment;
import com.test.fragment.fragmenttabhost.fragment.MineFragment;
import com.test.fragment.fragmenttabhost.fragment.RemindFragment;
import com.test.fragment.fragmenttabhost.fragment.WorkFragment;

public class HomeActivity extends AppCompatActivity {
    private FragmentTabHost mTabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.layout_main_contain);
        initTab();
    }
    private void initTab() {
        TabHost.TabSpec homeTabSpec = mTabHost.newTabSpec("首页").setIndicator(getImage(R.drawable.tab_home_btn, "首页"));
        TabHost.TabSpec remindTabSpec = mTabHost.newTabSpec("提醒").setIndicator(getImage(R.drawable.tab_remind_btn, "首页"));
        mTabHost.addTab(homeTabSpec, HomeFragment.class, null);
        mTabHost.addTab(remindTabSpec, RemindFragment.class, null);
        mTabHost.addTab(workTabSpec, WorkFragment.class, null);
        mTabHost.addTab(mineTabSpec, MineFragment.class, null);
    }

    private View getImage(int srcId, String tabName) {
        View view = View.inflate(this, R.layout.item_tab, null);
        ImageView i = (ImageView) view.findViewById(R.id.tab_indicator_icon);
        TextView t = (TextView) view.findViewById(R.id.tab_indicator_hint);
        t.setText(tabName);
        i.setBackgroundResource(srcId);
        return view;
    }
}
