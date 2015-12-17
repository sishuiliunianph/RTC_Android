package com.ibm.rtc.rtc.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibm.rtc.rtc.model.Workitem;

/**
 * Created by Jack on 2015/12/17.
 */
public class WorkitemAdapter extends RecyclerArrayAdapter<Workitem, WorkitemAdapter.ViewHolder>{

    private final Resources resources;
    private WorkitemAdapterListener workitemAdapterListener;

    public WorkitemAdapter(Context context, LayoutInflater inflater) {
        super(inflater);
        resources = context.getResources();
    }

    @Override
    protected void onBindViewHolder(ViewHolder holder, Workitem item) {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    public interface WorkitemAdapterListener {
        void onItem(Workitem workitem);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
