package com.zhaopengfei.myapplication;

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

import com.zhaopengfei.myapplication.activity.BaseActivity;
import com.zhaopengfei.myapplication.adapter.CommunityViewPagerAdapter;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.fragment.FaxianFragment;
import com.zhaopengfei.myapplication.fragment.FenQuFragment;
import com.zhaopengfei.myapplication.fragment.TuijianFragment;
import com.zhaopengfei.myapplication.fragment.ZhiboFragment;
import com.zhaopengfei.myapplication.fragment.ZhuiFanFragment;

import java.util.ArrayList;

import butterknife.BindView;

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

    @Override
    protected void intListener() {

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

        navView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

    }

    protected void initData() {
        initFragment();
        //设置适配器
        adapter = new CommunityViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        //关联viewpager
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(tablayout.MODE_FIXED);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ZhiboFragment());
        fragments.add(new TuijianFragment());
        fragments.add(new ZhuiFanFragment());
        fragments.add(new FenQuFragment());
        fragments.add(new FaxianFragment());
    }

}
