package com.ibm.rtc.rtc.adapter;

import android.view.View;

import com.mikepenz.iconics.typeface.IIcon;

/**
 * Created by v-wajie on 1/11/2016.
 */
public class AttributeItem {
    private IIcon iIcon;
    private String attribute;
    private View.OnClickListener listener;

    public AttributeItem(IIcon iIcon, String attribute, View.OnClickListener listener) {
        this.iIcon = iIcon;
        this.attribute = attribute;
        this.listener = listener;
    }

    public String getAttribute() {
        return attribute;
    }

    public IIcon getiIcon() {
        return iIcon;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setiIcon(IIcon iIcon) {
        this.iIcon = iIcon;
    }
}
