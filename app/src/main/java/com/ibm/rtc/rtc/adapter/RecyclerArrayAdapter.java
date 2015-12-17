package com.ibm.rtc.rtc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jack on 2015/12/17.
 * abstract RecyclerArrayAdapter 数组适配器，并且提供了动态加载更多items的接口。
 */
public abstract class RecyclerArrayAdapter<ItemType, ViewHolder extends RecyclerView.ViewHolder>
    extends RecyclerView.Adapter<ViewHolder> {

    public List<ItemType> items;
    private ItemType type;
    private LayoutInflater inflater;
    private RecyclerAdapterContentListener recyclerAdapterContentListener;

    public RecyclerArrayAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
        items = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public ItemType getItem(int position) {
        return items.get(position);
    }

    public void add(ItemType item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void addAll(Collection<? extends ItemType> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        onBindViewHolder(holder, getItem(position));
        if (recyclerAdapterContentListener != null && position + lazyLoadCount() >= getItemCount()) {
            recyclerAdapterContentListener.loadMoreItems();
        }
    }

    protected abstract void onBindViewHolder(ViewHolder holder, ItemType item);

    protected int lazyLoadCount() {
        return 1;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void remove(ItemType item) {
        items.remove(item);
        notifyDataSetChanged();
    }

    public List<ItemType> getItems() {
        return items;
    }

    public void setRecyclerAdapterContentListener(RecyclerAdapterContentListener listener) {
        this.recyclerAdapterContentListener = listener;
    }

    public interface RecyclerAdapterContentListener {
        void loadMoreItems();
    }
}
