package com.zhaopengfei.myapplication.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.Constants;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.DonghuaAdapter;
import com.zhaopengfei.myapplication.adapter.fenquAdapter;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.bean.DonghuaBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by admin on 2017/3/21.
 */

public class FenQuFragment extends BaseFragment {

    @BindView(R.id.gv_fenqu)
    GridView gvFenqu;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private fenquAdapter adapter;
    private DonghuaAdapter donghuaAdapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fenqu_item_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        adapter = new fenquAdapter(mContext);
        gvFenqu.setAdapter(adapter);
        //联网
        getDataFragment();
    }

    private void getDataFragment() {
        OkHttpUtils.get().url(Constants.FENQU_JSON)
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
        DonghuaBean bean = JSON.parseObject(json, DonghuaBean.class);
        donghuaAdapter = new DonghuaAdapter(mContext, bean.getData());
        recyclerView.setAdapter(donghuaAdapter);
        GridLayoutManager manager = new GridLayoutManager(mContext,1);
        recyclerView.setLayoutManager(manager);
    }



}
