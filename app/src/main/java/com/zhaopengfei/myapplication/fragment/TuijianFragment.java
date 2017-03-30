package com.zhaopengfei.myapplication.fragment;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.TuiJianAdapter;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.bean.TuijianBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by admin on 2017/3/21.
 */

public class TuijianFragment extends BaseFragment {
    @BindView(R.id.gv_tuijian)
    GridView gvTuijian;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private TuiJianAdapter adapter;
    private TuijianBean tuijianBean;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_tuijian, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        getDataFragment();
        //下拉刷新
        swipeRefreshLayout.setColorSchemeColors(Color.GREEN,Color.RED);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataFragment();
            }
        });
    }

    private void getDataFragment() {
        OkHttpUtils.get().url("http://app.bilibili.com/x/feed/index?appkey=1d8b6e7d45233436&build=501000&idx=1490013261&mobi_app=android&network=wifi&platform=android&pull=true&style=2&ts=1490015599000&sign=af4edc66aef7e443c98c28de2b660aa4").id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
                //刷新完成后
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void processData(String json) {
        tuijianBean = JSON.parseObject(json, TuijianBean.class);
        adapter = new TuiJianAdapter(mContext, tuijianBean);
        gvTuijian.setAdapter(adapter);
    }

}
