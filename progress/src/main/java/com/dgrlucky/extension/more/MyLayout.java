package com.dgrlucky.extension.more;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

public class MyLayout extends LinearLayout {

    private CustomViewTarget<MyLayout,Drawable> viewTarget;

    public MyLayout(Context context) {
        this(context,null);
    }
    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }
    public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        viewTarget = new CustomViewTarget<MyLayout,Drawable>(this) {
            @Override
            protected void onResourceCleared(@Nullable Drawable placeholder) {

            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {

            }

            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                MyLayout myLayout = getView();
                myLayout.setBackground(resource);
            }
        };
    }

    public CustomViewTarget<MyLayout,Drawable> getTarget() {
        return viewTarget;
    }
}