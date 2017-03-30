package com.zhaopengfei.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.bean.TuijianBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/22.
 */

public class TuiJianAdapter extends BaseAdapter {

    private final Context mContext;
    private final TuijianBean datas;


    public TuiJianAdapter(Context mContext, TuijianBean tuijianBean) {
        this.mContext = mContext;
        this.datas = tuijianBean;
    }


    @Override
    public int getCount() {
        return 8;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.tuijian_adapter, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        TuijianBean.DataBean dataBean = datas.getData().get(position);

        Glide.with(mContext).load(dataBean.getCover()).into(viewHolder.iv_image);

        viewHolder.tvName.setText(dataBean.getTitle());
        viewHolder.tvRichang.setText(dataBean.getTname());
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.iv_image)
        ImageView iv_image;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_richang)
        TextView tvRichang;
        @BindView(R.id.card_view)
        CardView cardView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
