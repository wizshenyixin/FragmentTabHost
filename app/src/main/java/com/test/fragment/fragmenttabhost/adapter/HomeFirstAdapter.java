package com.test.fragment.fragmenttabhost.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.test.fragment.fragmenttabhost.R;

import java.util.ArrayList;


public class HomeFirstAdapter extends PagerAdapter {
    private ArrayList<Integer> ids;
    private Context context;

    public HomeFirstAdapter(Context context, ArrayList<Integer> ids) {
        this.context = context;
        this.ids = ids;
    }

    @Override
    public int getCount() {
        return ids.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.item_home_first_pager, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_home_first_view);
        imageView.setBackgroundResource(ids.get(position));
        view.setTag(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
