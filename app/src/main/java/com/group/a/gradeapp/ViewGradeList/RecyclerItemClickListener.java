package com.group.a.gradeapp.ViewGradeList;

import android.view.View;

/**
 * The interface Recycler item click listener.
 */
// Adapter from https://android.jlelse.eu/click-listener-for-recyclerview-adapter-2d17a6f6f6c9
public interface RecyclerItemClickListener {

    /**
     * On click.
     *
     * @param view     the view
     * @param position the position
     */
    void onClick(View view, int position);
}