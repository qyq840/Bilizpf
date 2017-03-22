package com.zhaopengfei.myapplication.fragment;

import android.view.View;
import android.widget.TextView;

import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.base.BaseFragment;

/**
 * Created by admin on 2017/3/21.
 */

public class FenQuFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        View view =View.inflate(mContext, R.layout.fenqu_item_fragment,null);
        return view;
    }

    @Override
    protected void initData() {

    }
}
