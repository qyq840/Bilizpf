package com.zhaopengfei.myapplication.fragment;

import android.view.View;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.ZFAdapter;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.bean.ZhuiFanBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by admin on 2017/3/21.
 */

public class ZhuiFanFragment extends BaseFragment {
    @BindView(R.id.name)
    GridView name;

    private ZFAdapter adapter;
    private ZhuiFanBean zhuiFanBean;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_zhuifan, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {

        OkHttpUtils.get().url("http://bangumi.bilibili.com/api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                proessData(response);
            }
        });
    }

    private void proessData(String json) {
        zhuiFanBean = JSON.parseObject(json, ZhuiFanBean.class);
        ZhuiFanBean.ResultBean.PreviousBean previous = zhuiFanBean.getResult().getPrevious();
        //设置适配器
        adapter = new ZFAdapter(mContext,previous);
        name.setAdapter(adapter);
    }

}
