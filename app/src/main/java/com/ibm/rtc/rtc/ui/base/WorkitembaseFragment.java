package com.ibm.rtc.rtc.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.ibm.rtc.rtc.core.VolleyQueue;

/**
 * Created by v-wajie on 1/6/2016.
 */
public abstract class WorkitembaseFragment extends Fragment {

    protected static final String WORKITEM_ID = "WORKITEM_ID";
    private int mWorkitemId;
    private RequestQueue mRequestQueue;

    private void loadArguments() {
        if (getArguments() != null) {
            mWorkitemId = getArguments().getInt(WORKITEM_ID);
        } else {
            throw new IllegalStateException("The Workitem must not be null");
        }
    }

    protected int getWorkitemId() {
        return mWorkitemId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadArguments();
        mRequestQueue = VolleyQueue.getInstance(getActivity()).getRequestQueue();
    }

    protected void addToRequestQueue(Request request) {
        mRequestQueue.add(request);
    }
}
