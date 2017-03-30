package com.zhaopengfei.myapplication.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 刘闯 on 2017/3/21.
 */

public abstract class LiveBaseViewHolder extends RecyclerView.ViewHolder {
    public LiveBaseViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void setData();
}
