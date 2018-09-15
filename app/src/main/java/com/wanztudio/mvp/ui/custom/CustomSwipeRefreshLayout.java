package com.wanztudio.mvp.ui.custom;


import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {

    private View mTargetView;

    public CustomSwipeRefreshLayout(Context context) {
        super(context);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setTargetView(View targetView) {
        mTargetView = targetView;
    }

    @Override
    public boolean canChildScrollUp() {
        if(mTargetView != null)
            return this.mTargetView.canScrollVertically(-1);
        return false;
    }
}
