package com.zhaopengfei.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by admin on 2017/3/25.
 */

public class MyList extends View {
    public MyList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyList(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
