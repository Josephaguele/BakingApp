package com.example.joseph.thebakingapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.joseph.thebakingapp.R;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
   private int space;
    private Drawable mDivider;

    public SpacesItemDecoration(int space) { this.space = space; }


    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildLayoutPosition(view) == 0){
            outRect.top = space;
        } else {
            outRect.top = 0;
        }

    }


}
