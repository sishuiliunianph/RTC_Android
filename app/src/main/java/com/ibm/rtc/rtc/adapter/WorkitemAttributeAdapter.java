package com.ibm.rtc.rtc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibm.rtc.rtc.R;
import com.mikepenz.iconics.view.IconicsImageView;

/**
 * Created by v-wajie on 1/11/2016.
 */
public class WorkitemAttributeAdapter extends
        RecyclerArrayAdapter<AttributeItem, WorkitemAttributeAdapter.ViewHolder> {


    public WorkitemAttributeAdapter(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getInflater().inflate(R.layout.row_workitem_attribute, parent, false));
    }

    @Override
    protected void onBindViewHolder(ViewHolder holder, AttributeItem item) {
        if (item.getListener() != null) {
            holder.setListener(item.getListener());
        }

        holder.textAttribute.setText(item.getAttribute());
        holder.image.setIcon(item.getiIcon());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        TextView textAttribute;
        IconicsImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textAttribute = (TextView) itemView.findViewById(R.id.attribute);
            image = (IconicsImageView) itemView.findViewById(R.id.image);
        }

        public void setListener(View.OnClickListener listener) {
            itemView.setOnClickListener(listener);
        }
    }

}
