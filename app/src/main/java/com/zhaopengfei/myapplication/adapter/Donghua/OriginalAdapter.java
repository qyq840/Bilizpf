package com.zhaopengfei.myapplication.adapter.Donghua;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhaopengfei.myapplication.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by admin on 2017/3/24.
 */

public class OriginalAdapter extends FragmentPagerAdapter {

    private ArrayList<BaseFragment> fragments;
    private String title[] = new String[]{"原创","全站","番剧"};

    public OriginalAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }


}
