package com.zhaopengfei.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhaopengfei.myapplication.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by admin on 2017/3/25.
 */

public class QuanQuAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> fragments;
    private String title[] = {"番剧", "动画", "国创", "音乐", "舞蹈", "游戏", "科技", "生活", "鬼畜", "时尚", "娱乐", "电影", "电视剧"};

    public QuanQuAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
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
