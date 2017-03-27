package com.zhaopengfei.myapplication.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.activity.HuoDongActivity;
import com.zhaopengfei.myapplication.activity.OriginalActivity;
import com.zhaopengfei.myapplication.activity.QuanQuRankingActivity;
import com.zhaopengfei.myapplication.activity.TopicCenterActivity;
import com.zhaopengfei.myapplication.base.BaseFragment;
import com.zhaopengfei.myapplication.bean.TagBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

import static com.zhaopengfei.myapplication.R.id.activity_center_layout;
import static com.zhaopengfei.myapplication.R.id.ic_all_rank;
import static com.zhaopengfei.myapplication.R.id.layout_original;

/**
 * Created by admin on 2017/3/21.
 */

public class FaxianFragment extends BaseFragment {
    @BindView(R.id.search_scan)
    ImageView searchScan;
    @BindView(R.id.search_edit)
    TextView searchEdit;
    @BindView(R.id.search_img)
    ImageView searchImg;
    @BindView(R.id.card_view)
    CardView cardView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tags_layout)
    TagFlowLayout tagsLayout;
    @BindView(R.id.hide_tags_layout)
    TagFlowLayout hideTagsLayout;
    @BindView(R.id.hide_scroll_view)
    NestedScrollView hideScrollView;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.more_layout)
    LinearLayout moreLayout;
    @BindView(R.id.ic_quanzi)
    ImageView icQuanzi;
    @BindView(R.id.ic_quanzi_layout)
    RelativeLayout icQuanziLayout;
    @BindView(R.id.ic_topic)
    ImageView icTopic;
    @BindView(R.id.ic_activity)
    ImageView icActivity;
    @BindView(activity_center_layout)
    RelativeLayout activityCenterLayout;
    @BindView(R.id.ic_original)
    ImageView icOriginal;
    @BindView(layout_original)
    RelativeLayout layoutOriginal;
    @BindView(ic_all_rank)
    ImageView icAllRank;
    @BindView(R.id.layout_all_rank)
    RelativeLayout layoutAllRank;
    @BindView(R.id.ic_game)
    ImageView icGame;
    @BindView(R.id.layout_game_center)
    RelativeLayout layoutGameCenter;
    @BindView(R.id.ic_shop)
    ImageView icShop;
    @BindView(R.id.layout_shop)
    RelativeLayout layoutShop;
    @BindView(R.id.topic_center_layout)
    RelativeLayout topicCenterLayout;
    @BindView(R.id.quanqu)
    TextView quanqu;
    private TagBean tagBean;

    private List<TagBean.DataBean.ListBean> datas;

    private boolean isShowMore = true;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_item_fenlei, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {

        initListener();

        getTagNet();


    }

    private void getTagNet() {

        OkHttpUtils.get()
                .url("http://app.bilibili.com/x/v2/search/hot?appkey=1d8b6e7d45233436&build=501000&limit=50&mobi_app=android&platform=android&ts=1490014710000&sign=e5ddf94fa9a0d6876cb85756c37c4adc")
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "onError: 联网失败" + e.getMessage());

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "onResponse: 联网成功" + response);
                        processData(response);
                    }
                });

    }

    private void processData(String json) {
        tagBean = JSON.parseObject(json, TagBean.class);
        datas = tagBean.getData().getList();

        List<TagBean.DataBean.ListBean> listBeen = datas.subList(0, 8);

        tagsLayout.setAdapter(new TagAdapter<TagBean.DataBean.ListBean>(listBeen) {

            @Override
            public View getView(FlowLayout parent, final int position, final TagBean.DataBean.ListBean listBean) {
                TextView tags = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.layout_tags_item, parent, false);
                tags.setText(listBean.getKeyword());
                tags.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "position" + listBean.getKeyword(), Toast.LENGTH_SHORT).show();
                    }
                });

                return tags;
            }
        });
        hideTagsLayout.setAdapter(new TagAdapter<TagBean.DataBean.ListBean>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, final TagBean.DataBean.ListBean datas) {
                TextView tags = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.layout_tags_item, parent, false);
                tags.setText((datas.getKeyword()));
                tags.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "position" + datas.getKeyword(), Toast.LENGTH_SHORT).show();
                    }
                });

                return tags;
            }
        });


    }


    private void initListener() {


        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowMore) {
                    isShowMore = false;

                    hideScrollView.setVisibility(View.VISIBLE);

                    tvMore.setText("收起");
                    tagsLayout.setVisibility(View.GONE);

                    Drawable updrawable = getResources().getDrawable(R.drawable.ic_arrow_up_gray_round);
                    updrawable.setBounds(0, 0, updrawable.getMinimumWidth(), updrawable.getMinimumHeight());
                    tvMore.setCompoundDrawables(updrawable, null, null, null);

                } else {
                    isShowMore = true;
                    hideScrollView.setVisibility(View.GONE);
                    tvMore.setText("查看更多");
                    tagsLayout.setVisibility(View.VISIBLE);
                    Drawable downdrawable = getResources().getDrawable(R.drawable.ic_arrow_down_gray_round);
                    downdrawable.setBounds(0, 0, downdrawable.getMinimumWidth(), downdrawable.getMinimumHeight());
                    tvMore.setCompoundDrawables(downdrawable, null, null, null);
                }
            }
        });

        //全区排行
        quanqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, QuanQuRankingActivity.class));
            }
        });
        //原创排行
        layoutOriginal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, OriginalActivity.class));
            }
        });

        //活动中心的
        activityCenterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, HuoDongActivity.class));
            }
        });


        //话题中心
        topicCenterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, TopicCenterActivity.class));
            }
        });


    }


}
