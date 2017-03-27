package com.zhaopengfei.myapplication.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhaopengfei.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BannerActivity extends AppCompatActivity {


    @BindView(R.id.iv_back_banner)
    ImageView ivBackBanner;
    @BindView(R.id.tv_titile_name)
    TextView tvTitileName;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.activity_banner)
    LinearLayout activityBanner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ButterKnife.bind(this);

        WebSettings webSettings = webview.getSettings();


        //設置js
        webSettings.setJavaScriptEnabled(true);
        //設置添加縮放按鈕
        webSettings.setBuiltInZoomControls(true);
        //設置雙擊 d點擊
        webSettings.setUseWideViewPort(true);
        //設置webviewclient，果果沒有設置 調用系統的瀏覽器打開新的連接
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //加載完隱藏
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return true;

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl("http://live.bilibili.com/AppBanner/index?id=481");

    }


    @OnClick(R.id.iv_back_banner)
    public void onClick() {
        finish();
    }

}
