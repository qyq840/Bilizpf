package com.zhaopengfei.myapplication.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.Constants;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.ZhiboAdapter;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.bean.ZhiBobean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by admin on 2017/3/21.
 */

public class ZhiboFragment extends BaseFragment {


    @BindView(R.id.rv_home)
    RecyclerView rvHome;
    private ZhiboAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_zhibo, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        getDataFragment();
    }

    private void getDataFragment() {
        OkHttpUtils.get().url(Constants.BBASE_URL).id(100).build().execute(new StringCallback() {
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
        ZhiBobean zhiBobean = JSON.parseObject(json, ZhiBobean.class);
        //Log.e("TAG", "解析成功 processData()" + zhiBobean.getData().getBanner().get(0).getTitle());


        //设置设配器
        adapter = new ZhiboAdapter(mContext, zhiBobean.getData());
        rvHome.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(mContext, 1);

        //设置布局管理器
        rvHome.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                return 1;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
