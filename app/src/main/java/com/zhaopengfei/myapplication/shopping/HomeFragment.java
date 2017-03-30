package com.zhaopengfei.myapplication.shopping;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.Constants;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.shopping.adapter.homefragmentAdapter;
import com.zhaopengfei.myapplication.shopping.bean.homepageBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by admin on 2017/3/28.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.rl_recyclerview)
    RecyclerView rlRecyclerview;

    private homefragmentAdapter adapter;
    private List<homepageBean.ResultBean.RecordsBean> records;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.home_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        OkHttpUtils.get().url(Constants.QUANBU_SHANGPIN).build().execute(new StringCallback() {
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
        homepageBean homepageBean = JSON.parseObject(json, homepageBean.class);
        records = homepageBean.getResult().getRecords();
        //设置适配器

        adapter =new homefragmentAdapter(mContext, records);
        rlRecyclerview.setAdapter(adapter);
        rlRecyclerview.setLayoutManager(new GridLayoutManager(mContext,2));

    }

}
