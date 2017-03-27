package com.zhaopengfei.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.activity.DanmkuVideoActivity;
import com.zhaopengfei.myapplication.bean.ZhiBobean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/22.
 */

public class HuihuaAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ZhiBobean.DataBean.PartitionsBean> datas;


    public HuihuaAdapter(Context mContext, List<ZhiBobean.DataBean.PartitionsBean> partitions) {
        this.mContext = mContext;
        this.datas = partitions;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_huihua_adapter, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.tvName.setText(datas.get(position).getLives().get(0).getTitle());

        Glide.with(mContext).load(datas.get(position).getLives().get(0).getCover().getSrc())
                .into(viewHolder.ivHuitu);


        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mContext, DanmkuVideoActivity.class);
                intent.putExtra("video",datas.get(position).getLives().get(position).getPlayurl());
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.iv_huitu)
        ImageView ivHuitu;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.card_view)
        CardView cardView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
