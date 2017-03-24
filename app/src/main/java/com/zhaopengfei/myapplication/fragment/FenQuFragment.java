package com.zhaopengfei.myapplication.fragment;

import android.view.View;
import android.widget.GridView;

import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.fenquAdapter;
import com.zhaopengfei.myapplication.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/21.
 */

public class FenQuFragment extends BaseFragment {
    @BindView(R.id.gv_fenqu)
    GridView gvFenqu;

    private fenquAdapter adapter;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fenqu_item_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {

        adapter = new fenquAdapter(mContext);
        gvFenqu.setAdapter(adapter);

    }


}
