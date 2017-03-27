package com.zhaopengfei.myapplication.QuanQu;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.bean.HisPlayBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by admin on 2017/3/25.
 */

public class HisplayFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private HisplayFragmentAdapter adapter;
    private HisPlayBean hisPlayBean;
    private List<HisPlayBean.DataBean> data;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.hisplay_fragment, null);
        ButterKnife.bind(this,view);

        return view;

    }

    @Override
    protected void initData() {

        OkHttpUtils.get()
                .url("http://app.bilibili.com/x/v2/rank/region?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&pn=1&ps=20&rid=13&ts=1490017056000&sign=6825377c5a626fa80913d27e41ab8049")
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String json) {
        hisPlayBean = JSON.parseObject(json, HisPlayBean.class);

        data = hisPlayBean.getData();

        adapter = new HisplayFragmentAdapter(mContext, data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }
}
