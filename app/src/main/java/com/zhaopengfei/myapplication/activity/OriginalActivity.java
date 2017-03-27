package com.zhaopengfei.myapplication.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.Donghua.OriginalAdapter;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.found.HisPlayFragment;
import com.zhaopengfei.myapplication.found.QuanZhanFragment;
import com.zhaopengfei.myapplication.found.originalFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class OriginalActivity extends BaseActivity {

    @BindView(R.id.iv_back_yuanchuang)
    ImageView ivBackYuanchuang;
    @BindView(R.id.title_slide)
    LinearLayout titleSlide;
    @BindView(R.id.title_download)
    ImageView titleDownload;
    @BindView(R.id.title_search)
    ImageView titleSearch;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private OriginalAdapter adapter;
    private ArrayList<BaseFragment> fragments;

    @Override
    protected void intListener() {

    }

    @Override
    protected void initData() {

        initFragment();
        adapter = new OriginalAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

        //关联
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(tablayout.MODE_SCROLLABLE);
    }

    private void initFragment() {
        fragments = new ArrayList<>();

        fragments.add(new originalFragment());
        fragments.add(new QuanZhanFragment());
        fragments.add(new HisPlayFragment());

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_original;
    }


    @OnClick({R.id.iv_back_yuanchuang, R.id.title_download, R.id.title_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_yuanchuang:
                finish();
                break;
            case R.id.title_download:
                Toast.makeText(OriginalActivity.this, "下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.title_search:
                Toast.makeText(OriginalActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
