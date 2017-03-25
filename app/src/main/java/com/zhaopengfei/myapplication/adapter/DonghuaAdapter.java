package com.zhaopengfei.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.AccordionTransformer;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.adapter.Donghua.DonghuaAdapterOne;
import com.zhaopengfei.myapplication.bean.DonghuaBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/24.
 */

public class DonghuaAdapter extends RecyclerView.Adapter {


    private final Context mContext;
    private final List<DonghuaBean.DataBean> data;

    public static final int DONGHUA = 0;
    public static final int BANNER = 1;


    private int currenType = DONGHUA;

    private LayoutInflater inflater;


    public DonghuaAdapter(Context mContext, List<DonghuaBean.DataBean> data) {
        this.inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.data = data;

    }


    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == DONGHUA) {
            currenType = DONGHUA;
        } else if (position == BANNER) {
            currenType = BANNER;
        }
        return currenType;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DONGHUA) {
            return new DonghuaVolder(mContext, inflater.inflate(R.layout.donghuaone_item_adapter, null));
        } else if (viewType == BANNER) {
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == DONGHUA) {
            DonghuaVolder volder = (DonghuaVolder) holder;
            volder.setData(data.get(0).getBody());
        } else if (getItemViewType(position) == BANNER) {
            BannerViewHolder viewHolder = (BannerViewHolder) holder;
            viewHolder.setData(data.get(0).getBanner().getBottom());
        }
    }

    //baner
    class BannerViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        @BindView(R.id.banner)
        Banner banner;
        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext=mContext;
            ButterKnife.bind(this,itemView);
        }

        public void setData(List<DonghuaBean.DataBean.BannerBean.BottomBean> bottom) {

            //得到数据
            //設置banner的数据
            final List<String> images = new ArrayList<>();
            for (int i = 0; i < bottom.size(); i++) {
                images.add(bottom.get(i).getImage());
            }

            //簡單使用
            banner.setImages(images).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {

                    Glide.with(context)
                            .load(path)
                            .crossFade()
                            .into(imageView);
                }
            }).start();

            //設置 title 手风琴的样式
            banner.setBannerAnimation(AccordionTransformer.class);
        }
    }


    class DonghuaVolder extends RecyclerView.ViewHolder {

        private final Context mContext;
        @BindView(R.id.gv_gridview)
        GridView gvGridview;
        @BindView(R.id.tv_jiazaidonghua)
        TextView tvJiazaidonghua;
        private DonghuaAdapterOne adapter;

        public DonghuaVolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ButterKnife.bind(this, itemView);
        }

        public void setData(List<DonghuaBean.DataBean.BodyBean> body) {
            //设置适配器
            adapter = new DonghuaAdapterOne(mContext, body);
            gvGridview.setAdapter(adapter);
        }
    }
}
