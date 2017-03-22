package com.zhaopengfei.myapplication.fragment;

import android.view.View;
import android.widget.TextView;

import com.zhaopengfei.myapplication.base.BaseFragment;

/**
 * Created by admin on 2017/3/21.
 */

public class TuijianFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setText("3333");
        textView.setTextSize(20);
        return textView;
    }

    @Override
    protected void initData() {

    }
}
