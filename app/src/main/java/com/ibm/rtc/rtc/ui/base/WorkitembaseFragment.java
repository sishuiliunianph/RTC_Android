package com.ibm.rtc.rtc.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.ibm.rtc.rtc.core.VolleyQueue;
import com.ibm.rtc.rtc.model.Workitem;

/**
 * Created by v-wajie on 1/6/2016.
 */
public abstract class WorkitembaseFragment extends Fragment {

    protected static final String WORKITEM_INFO = "WORKITEM_INFO";
    private Workitem mWorkitem;
    private RequestQueue mRequestQueue;

    private void loadArguments() {
        if (getArguments() != null) {
            mWorkitem = getArguments().getParcelable(WORKITEM_INFO);
        } else {
            throw new IllegalStateException("The Workitem must not be null");
        }
    }

    protected Workitem getWorkitem() {
        return mWorkitem;
    }

    protected void setWorkitem(Workitem workitem) {
        mWorkitem = workitem;
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
