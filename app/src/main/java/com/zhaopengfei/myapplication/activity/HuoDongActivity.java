package com.zhaopengfei.myapplication.activity;

import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.HuoDongAdapter;
import com.zhaopengfei.myapplication.bean.HuoDongBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

public class HuoDongActivity extends BaseActivity {

    @BindView(R.id.iv_back_huati)
    ImageView ivBackHuati;
    @BindView(R.id.navigation_layout)
    LinearLayout navigationLayout;
    @BindView(R.id.lv_huati)
    ListView lvHuati;
    @BindView(R.id.activity_huati)
    CoordinatorLayout activityHuati;
    @BindView(R.id.activity_huo_dong)
    RelativeLayout activityHuoDong;
    private HuoDongBean huoDongBean;


    private HuoDongAdapter adapter;
    @Override
    protected void intListener() {
        ivBackHuati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        OkHttpUtils.get().url("http://api.bilibili.com/event/getlist?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&page=1&pageSize=20&platform=android&ts=1490338432000&sign=f7265d81f829a0ec759bb09fa93001f1").build().execute(new StringCallback() {
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
        huoDongBean = JSON.parseObject(json, HuoDongBean.class);
        List<HuoDongBean.ListBean> datas = huoDongBean.getList();

        adapter =new HuoDongAdapter(this,datas);
        lvHuati.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_huo_dong;
    }

}
