package com.zhaopengfei.myapplication.shopping.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.shopping.GoodsInfoActivity;
import com.zhaopengfei.myapplication.shopping.bean.homepageBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/28.
 */

public class homefragmentAdapter extends RecyclerView.Adapter<homefragmentAdapter.ViewHolder> {


    public static final String IMAGE = "image";
    public static final String NAME = "name";
    public static final String MONEY = "money";
    private final Context mContext;
    private final List<homepageBean.ResultBean.RecordsBean> datas;

    public homefragmentAdapter(Context mContext, List<homepageBean.ResultBean.RecordsBean> records) {
        this.mContext = mContext;
        this.datas = records;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final homepageBean.ResultBean.RecordsBean Bean = datas.get(position);

        Glide.with(mContext).load(Bean.getImgUrl()).into(holder.ivImage);
        holder.tvMoney.setText(Bean.getSalvePrice() + "");
        holder.tvName.setText(Bean.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GoodsInfoActivity.class);
                intent.putExtra(IMAGE,Bean);
//                intent.putExtra(NAME,Bean.getTitle());
//                intent.putExtra(MONEY,Bean.getSalvePrice()+"");
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.card_view)
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
