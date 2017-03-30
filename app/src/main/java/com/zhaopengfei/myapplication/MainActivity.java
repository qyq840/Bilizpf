package com.zhaopengfei.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;
import com.zhaopengfei.myapplication.activity.BaseActivity;
import com.zhaopengfei.myapplication.activity.LoginActivity;
import com.zhaopengfei.myapplication.adapter.CommunityViewPagerAdapter;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.fragment.FaxianFragment;
import com.zhaopengfei.myapplication.fragment.FenQuFragment;
import com.zhaopengfei.myapplication.fragment.TuijianFragment;
import com.zhaopengfei.myapplication.fragment.ZhiboFragment;
import com.zhaopengfei.myapplication.fragment.ZhuiFanFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.title_slide)
    LinearLayout titleSlide;
    @BindView(R.id.title_game)
    ImageView titleGame;
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
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.tv_longin)
    TextView tvLongin;
    private ArrayList<BaseFragment> fragments;
    private CommunityViewPagerAdapter adapter;


    /*@Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {


        } else if (id == R.id.nav_big_vip) {

        } else if (id == R.id.nav_vip_jifen) {

        } else if (id == R.id.nav_download) {

        } else if (id == R.id.nav_shaohouzaikan) {

        } else if (id == R.id.nav_shoucang) {

        } else if (id == R.id.nav_lishijilu) {

        } else if (id == R.id.nav_guanzhu) {

        } else if (id == R.id.nav_b_money) {

        } else if (id == R.id.zhuti) {

        } else if (id == R.id.setting) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ZhiboFragment());
        fragments.add(new TuijianFragment());
        fragments.add(new ZhuiFanFragment());
        fragments.add(new FenQuFragment());
        fragments.add(new FaxianFragment());
    }

    @OnClick({R.id.title_game, R.id.title_download, R.id.title_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_game:
                Toast.makeText(MainActivity.this, "游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.title_download:
                Toast.makeText(MainActivity.this, "下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.title_search:

                //实例化
                SearchFragment searchFragment = SearchFragment.newInstance();

                //第二句 , 设置回调
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        Toast.makeText(MainActivity.this, keyword, Toast.LENGTH_SHORT).show();
                    }
                });
                //3
                searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);


                break;

        }
    }

    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initListener() {
        titleSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
                navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        drawerLayout.closeDrawer(GravityCompat.START);

                        return true;
                    }
                });

            }
        });



        tvLongin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        navView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(String json, String error) {
        initFragment();
        //设置适配器
        adapter = new CommunityViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        //关联viewpager
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(tablayout.MODE_FIXED);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

}
