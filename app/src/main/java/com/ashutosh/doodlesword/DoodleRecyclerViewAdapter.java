package com.ashutosh.doodlesword;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by Vostro-Daily on 7/29/2015.
 */
public class DoodleRecyclerViewAdapter<T extends DoodleRecylerViewSetter> extends RecyclerView.Adapter<DoodleRecyclerHolder<T>> {
    List<T> lst = null;

    DoodleRecyclerViewAdapter(List<T> items){
        lst = items;
    }

    @Override
    public DoodleRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout lt = new LinearLayout(parent.getContext());
        return new DoodleRecyclerHolder(lt);
    }

    @Override
    public void onBindViewHolder(DoodleRecyclerHolder holder, int position) {
        T item = lst.get(position);
        item.setView(holder.vg);
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }
}
