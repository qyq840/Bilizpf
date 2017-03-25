package com.zhaopengfei.myapplication.found;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.bean.OriginalBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/25.
 */

public class originalFragmentAdapter extends RecyclerView.Adapter<originalFragmentAdapter.ViewHolder> {

    private final Context mContext;
    private final List<OriginalBean.DataBean> datas;

    public originalFragmentAdapter(Context mContext, List<OriginalBean.DataBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
        Log.e("TAG", "originalFragmentAdapter originalFragmentAdapter()"+datas.toString());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_original, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(datas,position);


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ig_image)
        ImageView igImage;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.tv_pingfen)
        TextView tvPingfen;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(List<OriginalBean.DataBean> datas, int position) {
            OriginalBean.DataBean dataBean = datas.get(position);
            Glide.with(mContext).load(dataBean.getCover()).into(igImage);
            name.setText(dataBean.getName());
            title.setText(dataBean.getTitle());
            tvPingfen.setText("综合评分：" + dataBean.getPlay());
        }
    }
}
