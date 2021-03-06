package com.zhaopengfei.myapplication.base;

import android.text.TextUtils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


public class NetUtils {

    private NetUtils() {
    }

    static class Tool {
        private static NetUtils okhttpUtils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return Tool.okhttpUtils;
    }

    /**
     * @param url    url
     * @param result resultBean 回调bean的接口
     */
    public void okhttpUtilsget( String url,final resultJson result) {
        if (result == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            result.onError("url为空无法请求");
            return;
        }
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                result.onError(e.getMessage());
            }
            @Override
            public void onResponse(String response, int id) {
                if (TextUtils.isEmpty(response)) {
                    result.onError("请求结果为空 无法解析");
                    return;
                }
                result.onResponse(response);
            }
        });
    }



    public interface resultJson {
        void onResponse(String bean);

        void onError(String error);
    }

}
