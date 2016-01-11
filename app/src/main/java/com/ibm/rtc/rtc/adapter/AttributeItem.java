package com.ibm.rtc.rtc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibm.rtc.rtc.R;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.view.IconicsImageView;

/**
 * Created by v-wajie on 1/11/2016.
 */
public class AttributeItem {
    private IIcon iIcon;
    private String attribute;
    private View.OnClickListener listener;

    private IconicsImageView imageView;
    private TextView textView;
    private View view;

    public AttributeItem(IIcon iIcon, String attribute, View.OnClickListener listener) {
        this.iIcon = iIcon;
        this.attribute = attribute;
        this.listener = listener;
    }

    public View getView(Context context, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.row_workitem_attribute, parent, false);

        imageView = (IconicsImageView) view.findViewById(R.id.image);
        textView = (TextView) view.findViewById(R.id.attribute);

        imageView.setIcon(iIcon);
        imageView.setPaddingDp(16);

        textView.setText(attribute);

        if (listener != null) {
            view.setOnClickListener(listener);
        }

        return view;
    }


    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

}
