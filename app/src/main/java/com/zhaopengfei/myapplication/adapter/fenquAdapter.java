package com.zhaopengfei.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaopengfei.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/3/22.
 */

public class fenquAdapter extends BaseAdapter {

    private final Context mContext;

    private int image[] = {R.drawable.ic_category_live, R.drawable.ic_category_t13,
            R.drawable.ic_category_t1, R.drawable.ic_category_t3, R.drawable.ic_category_t129, R.drawable.ic_category_t4,
            R.drawable.ic_category_t36, R.drawable.ic_category_t160, R.drawable.ic_category_t119, R.drawable.ic_category_t155,
            R.drawable.ic_category_t165, R.drawable.ic_category_t5, R.drawable.ic_category_t23, R.drawable.ic_category_t11,
            R.drawable.ic_category_game_center,};
    private String nameq[] = {"直 播", "番 剧", "动 画", "音 乐", "舞 蹈", "游 戏", "科 技", "生 活", "鬼 畜",
            "时 尚", "广 告", "娱 乐", "电 影", "电视剧", "游戏中心"};

    public fenquAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public int getCount() {
        return 15;
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.fenqu_item_adapter, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ivTupian.setImageResource(image[position]);

        viewHolder.name.setText(nameq[position]);

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_tupian)
        ImageView ivTupian;
        @BindView(R.id.name)
        TextView name;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
