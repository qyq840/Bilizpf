package com.zhaopengfei.myapplication.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zhaopengfei.myapplication.QuanQu.DanceFragment;
import com.zhaopengfei.myapplication.QuanQu.EntertainmentFragment;
import com.zhaopengfei.myapplication.QuanQu.FashionFragment;
import com.zhaopengfei.myapplication.QuanQu.GameFragment;
import com.zhaopengfei.myapplication.QuanQu.GuiChuFragment;
import com.zhaopengfei.myapplication.QuanQu.GuochuangFragment;
import com.zhaopengfei.myapplication.QuanQu.HisplayFragment;
import com.zhaopengfei.myapplication.QuanQu.KejiFragment;
import com.zhaopengfei.myapplication.QuanQu.LifeFragment;
import com.zhaopengfei.myapplication.QuanQu.MovieFragment;
import com.zhaopengfei.myapplication.QuanQu.MusicFragment;
import com.zhaopengfei.myapplication.QuanQu.TvFragment;
import com.zhaopengfei.myapplication.QuanQu.animationFragment;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.QuanQuAdapter;
import com.zhaopengfei.myapplication.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class QuanQuRankingActivity extends BaseActivity {


    @BindView(R.id.iv_back_quanqu)
    ImageView ivBackQuanqu;
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

    private QuanQuAdapter adapter;
    private ArrayList<BaseFragment> fragments;
    @Override
    protected void intListener() {

    }

    @Override
    protected void initData() {


        initFragment();
        adapter =new QuanQuAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HisplayFragment()); //番剧
        fragments.add(new animationFragment());//动画
        fragments.add(new GuochuangFragment());//国创
        fragments.add(new MusicFragment());//音乐
        fragments.add(new DanceFragment());//舞蹈
        fragments.add(new GameFragment());//游戏
        fragments.add(new KejiFragment());//科技
        fragments.add(new GuiChuFragment());//鬼畜
        fragments.add(new LifeFragment());//生活
        fragments.add(new FashionFragment());//时尚
        fragments.add(new EntertainmentFragment());//娱乐
        fragments.add(new MovieFragment());//电影
        fragments.add(new TvFragment());//电视剧

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_quan_qu_ranking;
    }


    @OnClick({R.id.iv_back_quanqu, R.id.title_download, R.id.title_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_quanqu:
                finish();
                break;
            case R.id.title_download:
                Toast.makeText(QuanQuRankingActivity.this, "下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.title_search:
                Toast.makeText(QuanQuRankingActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
