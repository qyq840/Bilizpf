package com.zhaopengfei.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.AccordionTransformer;
import com.zhaopengfei.myapplication.Constants;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.activity.BannerActivity;
import com.zhaopengfei.myapplication.bean.HomeBean;
import com.zhaopengfei.myapplication.bean.ZhiBobean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by admin on 2017/3/21.
 */

public class ZhiboAdapter extends RecyclerView.Adapter {


    //横幅
    public static final int BANNER = 0;
    //频道

    //推荐
    public static final int RECOMMEND = 1;


    public static final int HUIHUAZHUANQU = 2;

    private final Context mContext;
    private final ZhiBobean.DataBean data;



    private LayoutInflater inflater;

    private int currenType = BANNER;


    //硅谷

    private List<HomeBean.ResultBean.RecommendInfoBean> recommend_info;
    private RecommendViewHoler viewHoler;
    private HuihuaAdapter huihuaAdapter;

    public ZhiboAdapter(Context mContext, ZhiBobean.DataBean data) {
        this.inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.data = data;
    }


    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currenType = BANNER;
        } else if (position == RECOMMEND) {
            currenType = RECOMMEND;
        } else if (position == HUIHUAZHUANQU) {
            currenType = HUIHUAZHUANQU;
        }
        return currenType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            return new BannerViewHoler(mContext, inflater.inflate(R.layout.banner_adapter, null));
        } else if (viewType == RECOMMEND) {
            return new RecommendViewHoler(mContext, inflater.inflate(R.layout.recommend_adapter, null));
        } else if (viewType == HUIHUAZHUANQU) {
            return new HuihuaViewHoler(mContext, inflater.inflate(R.layout.huihua_adapter, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER) {
            BannerViewHoler viewHoler = (BannerViewHoler) holder;
            viewHoler.setData(data.getBanner());
            getDataFromNet();
        } else if (getItemViewType(position) == RECOMMEND) {
            viewHoler = (RecommendViewHoler) holder;

        } else if (getItemViewType(position) == HUIHUAZHUANQU) {
            HuihuaViewHoler viewHoler = (HuihuaViewHoler) holder;
            viewHoler.setData(data.getPartitions());

        }
    }


    //绘画专区
    class HuihuaViewHoler extends RecyclerView.ViewHolder {

        private final Context mContext;
        HuihuaAdapter adapter;

        @BindView(R.id.huituzhuanqu)
        ImageView huituzhuanqu;
        @BindView(R.id.zhiborenshu)
        TextView zhiborenshu;
        @BindView(R.id.gv_gridview)
        GridView gvGridview;
        public HuihuaViewHoler(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ButterKnife.bind(this, itemView);
        }


        public void setData(List<ZhiBobean.DataBean.PartitionsBean> partitions) {
            adapter = new HuihuaAdapter(mContext, partitions);
            gvGridview.setAdapter(adapter);





            Glide.with(mContext).load(partitions.get(0).getPartition().
                    getSub_icon().getSrc()).into(huituzhuanqu);





            zhiborenshu.setText(partitions.get(0).getPartition().getName());

            gvGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });


        }
    }


    private void getDataFromNet() {
        OkHttpUtils.get().url(Constants.HOME_URL).id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }


    class RecommendViewHoler extends RecyclerView.ViewHolder {

        private final Context mContext;
        @BindView(R.id.gv_recommend)
        GridView gvRecommend;
        private recommend_adapter adapter;

        public RecommendViewHoler(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ButterKnife.bind(this, itemView);
        }

        public void setData(List<HomeBean.ResultBean.RecommendInfoBean> recommend_info) {
            //设置适配器
            adapter = new recommend_adapter(mContext, recommend_info);
            gvRecommend.setAdapter(adapter);
        }

    }

    private void processData(String json) {
        HomeBean homeBean = JSON.parseObject(json, HomeBean.class);


        recommend_info = homeBean.getResult().getRecommend_info();
        viewHoler.setData(recommend_info);
    }

}


//banner
class BannerViewHoler extends RecyclerView.ViewHolder {
    private final Context mContext;
    @BindView(R.id.banner)
    Banner banner;

    public BannerViewHoler(Context mContext, View itemView) {
        super(itemView);
        this.mContext = mContext;
        ButterKnife.bind(this, itemView);
    }

    public void setData(final List<ZhiBobean.DataBean.BannerBean> banners) {
        List<String> imags = new ArrayList<>();
        for (int i = 0; i < banners.size(); i++) {
            imags.add(banners.get(i).getImg());

        }

        banner.setImages(imags).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                Glide.with(mContext).load(path).crossFade().into(imageView);
            }
        }).start();
        //设置样式
        banner.setBannerAnimation(AccordionTransformer.class);
        //点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                Intent intent = new Intent(mContext, BannerActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
}

