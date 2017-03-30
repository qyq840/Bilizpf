package com.zhaopengfei.myapplication.activity;

import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.Constants;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.TopicCenterAdapter;
import com.zhaopengfei.myapplication.bean.TopicCenterBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

public class TopicCenterActivity extends BaseActivity {


    @BindView(R.id.iv_back_huati)
    ImageView ivBackHuati;
    @BindView(R.id.navigation_layout)
    LinearLayout navigationLayout;
    @BindView(R.id.lv_huati)
    ListView lvHuati;
    @BindView(R.id.activity_huati)
    CoordinatorLayout activityHuati;
    private TopicCenterAdapter adapter;
    private TopicCenterBean topicCenterBean;
    private List<TopicCenterBean.ListBean> datas;


    private void processData(String json) {
        topicCenterBean = JSON.parseObject(json, TopicCenterBean.class);
        datas = topicCenterBean.getList();

        adapter = new TopicCenterAdapter(this,datas);
        lvHuati.setAdapter(adapter);

    }



    @Override
    protected String setUrl() {
        return null;
    }

    @Override
    protected void initListener() {
        ivBackHuati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(String json, String error) {
        OkHttpUtils.get().url(Constants.HUATIZHONGXIN_JSON).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_topic_center;
    }
}
