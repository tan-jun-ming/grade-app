package com.group.a.gradeapp;

import android.view.View;

// Adapter from https://android.jlelse.eu/click-listener-for-recyclerview-adapter-2d17a6f6f6c9
public interface RecyclerItemClickListener {

    void onClick(View view, int position);
}