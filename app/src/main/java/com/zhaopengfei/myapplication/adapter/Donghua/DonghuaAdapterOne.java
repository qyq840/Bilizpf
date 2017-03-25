package com.zhaopengfei.myapplication.adapter.Donghua;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhaopengfei.myapplication.R;
import com.zhaopengfei.myapplication.bean.DonghuaBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/24.
 */

public class DonghuaAdapterOne extends BaseAdapter {

    private final Context mContext;
    private final List<DonghuaBean.DataBean.BodyBean> datas;

    public DonghuaAdapterOne(Context mContext, List<DonghuaBean.DataBean.BodyBean> body) {
        this.mContext = mContext;
        this.datas = body;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.donghua_item_adapter, null);
            viewHolder =new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }else {
           viewHolder = (ViewHolder) convertView.getTag();
        }
        DonghuaBean.DataBean.BodyBean bodyBean = datas.get(position);
        Glide.with(mContext).load(bodyBean.getCover()).into(viewHolder.ivImage);
        viewHolder.tvName.setText(bodyBean.getTitle());
        return convertView;

    }

    static class ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_richang)
        TextView tvRichang;
        /*@BindView(R.id.banner)
        Banner banner;*/

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
