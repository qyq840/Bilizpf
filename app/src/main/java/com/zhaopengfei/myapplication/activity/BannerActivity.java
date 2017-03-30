package com.zhaopengfei.myapplication.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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
import cn.sharesdk.onekeyshare.OnekeyShare;

public class BannerActivity extends AppCompatActivity {


    @BindView(R.id.iv_back_banner)
    ImageView ivBackBanner;
    @BindView(R.id.tv_titile_name)
    TextView tvTitileName;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.activity_banner)
    LinearLayout activityBanner;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private String banner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ButterKnife.bind(this);

        initView();

        banner = getIntent().getStringExtra("banner");
        
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
        webview.loadUrl(banner);

    }

    private void initView() {



        toolbar.inflateMenu(R.menu.banner_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
//                int itemId = item.getItemId();
//                if(itemId==R.id.fenxiang) {
//                    Intent intent=new Intent(Intent.ACTION_SEND);
//                    intent.setType("image/*");
//                    intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
//                    intent.putExtra(Intent.EXTRA_TEXT, "I have successfully share my message through my app");
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(Intent.createChooser(intent, getTitle()));
//                }


                    OnekeyShare oks = new OnekeyShare();
                    //关闭sso授权
                    oks.disableSSOWhenAuthorize();
                    // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
                    oks.setTitle("标题");
                    // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
                    oks.setTitleUrl("http://sharesdk.cn");
                    // text是分享文本，所有平台都需要这个字段
                    oks.setText("我是分享文本");
                    //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
                    oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
                    // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                    //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                    // url仅在微信（包括好友和朋友圈）中使用
                    oks.setUrl("http://sharesdk.cn");
                    // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                    oks.setComment("我是测试评论文本");
                    // site是分享此内容的网站名称，仅在QQ空间使用
                    oks.setSite("ShareSDK");
                    // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                    oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
                    oks.show(BannerActivity.this);

                return true;
            }
        });
    }


    @OnClick(R.id.iv_back_banner)
    public void onClick() {
        finish();
    }

}
