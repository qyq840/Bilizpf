package com.zhaopengfei.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.zhaopengfei.myapplication.base.NetUtils;

import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/21.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        initView();
        initDataNet();
        initListener();
    }

    private void initDataNet() {
        if (TextUtils.isEmpty(setUrl())) {
            initData(null, "url为空无法请求数据");
            return;
        }
        NetUtils.getInstance().okhttpUtilsget(setUrl(), new NetUtils.resultJson() {
            @Override
            public void onResponse(String json) {
                initData(json, null);
            }

            @Override
            public void onError(String error) {
                initData(null, error);
            }
        });
    }

    protected abstract String setUrl();

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract void initData(String json, String error);

    protected abstract
    @LayoutRes
    int setLayoutId();


    protected void startActivity(Class activityClazz) {
        startActivity(new Intent(this, activityClazz));
    }

    //弹出Toast
    public void showToast(String context) {
        Toast.makeText(this, context, Toast.LENGTH_SHORT).show();

    }
}
