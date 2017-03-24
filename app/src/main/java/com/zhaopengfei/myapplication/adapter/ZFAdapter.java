package com.zhaopengfei.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.bean.ZhuiFanBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/23.
 */

public class ZFAdapter extends BaseAdapter {
    private final Context mContext;
    private final ZhuiFanBean.ResultBean.PreviousBean datas;


    public ZFAdapter(Context mContext, ZhuiFanBean.ResultBean.PreviousBean previous) {
        this.mContext = mContext;
        this.datas = previous;
    }

    @Override
    public int getCount() {
        return 3;
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.zhuifan_adapter, null);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(mContext).load(datas.getList().get(position).getCover()).into(viewHolder.ivImage);
        viewHolder.tvName.setText(datas.getList().get(position).getFavourites()+"人");
        viewHolder.tvRichang.setText(datas.getList().get(position).getTitle());
        viewHolder.tvjishu.setText("更新到第"+datas.getList().get(position).getNewest_ep_index()+"话");

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_richang)
        TextView tvRichang;
        @BindView(R.id.tv_jishu)
        TextView tvjishu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
