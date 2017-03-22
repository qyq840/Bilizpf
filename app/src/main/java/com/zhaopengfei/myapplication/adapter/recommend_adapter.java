package com.zhaopengfei.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.Constants;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.bean.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/22.
 */

public class recommend_adapter extends BaseAdapter {

    private final Context mContext;
    private final List<HomeBean.ResultBean.RecommendInfoBean> datas;

    public recommend_adapter(Context mContext, List<HomeBean.ResultBean.RecommendInfoBean> recommend_info) {
        this.mContext = mContext;
        this.datas = recommend_info;

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_recommend_adapter, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //根据位置得到相应的数据
        HomeBean.ResultBean.RecommendInfoBean recommendInfoBean = datas.get(position);

        //绑定数据
        viewHolder.tvMoney.setText(recommendInfoBean.getCover_price()+"$");
        viewHolder.tvName.setText(recommendInfoBean.getName());

        Glide.with(mContext).load(Constants.BASE_URL_IMAGE+ recommendInfoBean.getFigure()).into(viewHolder.ivRecommend);
        return convertView;

    }

    static class ViewHolder {
        @BindView(R.id.iv_recommend)
        ImageView ivRecommend;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_money)
        TextView tvMoney;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
