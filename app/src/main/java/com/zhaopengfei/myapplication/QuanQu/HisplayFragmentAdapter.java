package com.zhaopengfei.myapplication.QuanQu;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.bean.HisPlayBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/25.
 */

public class HisplayFragmentAdapter extends RecyclerView.Adapter<HisplayFragmentAdapter.ViewHolder> {


    private final Context mContext;
    private final List<HisPlayBean.DataBean> data;


    public HisplayFragmentAdapter(Context mContext, List<HisPlayBean.DataBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.hisplay_item_quanqu, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNum.setText(position + 1 + "");
        if (position < 3) {

            holder.tvNum.setTextColor(Color.parseColor("#fb7299"));

        }
        Glide.with(mContext).load(data.get(position).getCover()).into(holder.ivImage);
        holder.tvName.setText(data.get(position).getName());
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvPingfen.setText("综合评分" + data.get(position).getPlay());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_pingfen)
        TextView tvPingfen;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
