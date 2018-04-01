package com.lark.woodturning;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SwipeViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private ImageView imageView;

    SwipeViewHolder(View swipeView) {
        super(swipeView);
        imageView = swipeView.findViewById(R.id.swipe_image);
        textView = swipeView.findViewById(R.id.swipe_text);
    }

    public void bindData(Pair<String, Integer> data) {
        textView.setText(data.first);
        imageView.setImageResource(data.second);
    }
}
