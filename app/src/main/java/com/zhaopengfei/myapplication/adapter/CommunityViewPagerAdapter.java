package com.zhaopengfei.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhaopengfei.myapplication.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by admin on 2017/3/21.
 */

public class CommunityViewPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<BaseFragment> fragments;
    private String[] titles = new String[]{"直播", "推荐", "追番", "分区", "发现"};
    public CommunityViewPagerAdapter(FragmentManager fm,ArrayList<BaseFragment> fragments) {
        super(fm);
        this.fragments =fragments;
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
        return titles[position];
    }
}
