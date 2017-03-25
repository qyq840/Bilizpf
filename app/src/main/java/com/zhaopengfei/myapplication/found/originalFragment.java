package com.zhaopengfei.myapplication.found;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.bean.OriginalBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by admin on 2017/3/24.
 */

public class originalFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private originalFragmentAdapter adapter;
    private OriginalBean originalBean;
    private List<OriginalBean.DataBean> datas;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.original_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    protected void initData() {
        OkHttpUtils.get().url("http://app.bilibili.com/x/v2/rank?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&order=origin&platform=android&pn=1&ps=20&ts=1490015891000&sign=1a5a1c73e3b23be37fb13ee0178ceef0").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("TAG", "originalFragment onError()解析失败"+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                    processData(response);
                Log.e("TAG", "originalFragment onResponse()解析成功"+originalBean.getData().get(0).getName());
            }
        });

    }

    private void processData(String json) {
        originalBean = JSON.parseObject(json, OriginalBean.class);
        datas = originalBean.getData();
        Log.e("TAG", "originalFragment processData()11111");
        adapter =new originalFragmentAdapter(mContext, datas);
        recyclerView.setAdapter(adapter);
        Log.e("TAG", "originalFragment processData()2222");
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }
}
