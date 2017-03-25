package com.zhaopengfei.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.bean.HuoDongBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/24.
 */

public class HuoDongAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<HuoDongBean.ListBean> datas;

    public HuoDongAdapter(Context mContext, List<HuoDongBean.ListBean> datas) {
        this.mContext = mContext;
        this.datas = datas;

    }

    @Override
    public int getCount() {
        return datas.size();
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
        ViewHolder viewHolder =null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.huodong_item, null);
            viewHolder =new ViewHolder(convertView);

            convertView.setTag(viewHolder);

        }else {
           viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(datas.get(position).getCover()).into(viewHolder.ivImage);


        viewHolder.tvName.setText(datas.get(position).getTitle());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, ""+datas.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.card_view)
        CardView cardView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
