package com.ibm.rtc.rtc.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ibm.rtc.rtc.R;
import com.ibm.rtc.rtc.adapter.WorkitemAdapter;
import com.ibm.rtc.rtc.core.UrlManager;
import com.ibm.rtc.rtc.core.VolleyQueue;
import com.ibm.rtc.rtc.core.WorkitemsRequest;
import com.ibm.rtc.rtc.model.Project;
import com.ibm.rtc.rtc.model.Workitem;
import com.ibm.rtc.rtc.ui.base.LoadingListFragment;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.List;

/**
 * Created by Jack on 2015/12/23.
 */
public class WorkitemsListFragment extends LoadingListFragment<WorkitemAdapter> {
    private static final String TAG = "WorkitemsListFragment";
    private static final String PROJECT_INFO = "PROJECT_INFO";
    private RequestQueue mRequestQueue;
    private Project mProject;
    private final int DEFAULT_STATUS_CODE = 500;

    public static WorkitemsListFragment newInstance(Project project) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(PROJECT_INFO, project);
        WorkitemsListFragment workitemsListFragment = new WorkitemsListFragment();
        workitemsListFragment.setArguments(bundle);
        return workitemsListFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        loadArguments();
        mRequestQueue = VolleyQueue.getInstance(getActivity()).getRequestQueue();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.workitem_list_fragment, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        if (getActivity() != null) {
            MenuItem item = menu.findItem(R.id.workitem_filter);
            if (item != null) {
                item.setIcon(new IconicsDrawable(getActivity(), GoogleMaterial.Icon.gmd_filter_list)
                    .colorRes(R.color.white).actionBar());
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.workitem_filter:
                break;
        }

        return true;
    }

    private void loadArguments() {
        if (getArguments() != null) {
            mProject = getArguments().getParcelable(PROJECT_INFO);
        }
    }

    public void setUpList(List<Workitem> workitems) {
        WorkitemAdapter adapter = new WorkitemAdapter(getActivity(),
                LayoutInflater.from(getActivity()));
        adapter.setRecyclerAdapterContentListener(this);
        adapter.addAll(workitems);

        setAdapter(adapter);
    }

    @Override
    protected void executeRequest() {
        super.executeRequest();

        UrlManager urlManager = new UrlManager(getActivity());
        String workitemsUrl = urlManager.getRootUrl() + "workitems";
        WorkitemsRequest workitemsRequest = new WorkitemsRequest(workitemsUrl,
            new Response.Listener<List<Workitem>>() {
                @Override
                public void onResponse(List<Workitem> workitems) {
                    if (workitems != null && !workitems.isEmpty()) {
                        hideEmpty();
                        if (refreshing || getAdapter() == null) {
                            setUpList(workitems);
                        }
                    } else {
                        setEmpty();
                    }
                    stopRefresh();
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.d(TAG, "Fetch workitems error: " + volleyError.getMessage());
                    stopRefresh();

                    //TODO 设置合适的错误类型信息
                    setEmpty(true, volleyError.networkResponse == null ?
                        DEFAULT_STATUS_CODE : volleyError.networkResponse.statusCode);

                    if (getView() != null)
                        Snackbar.make(getView(), getText(R.string.workitem_refresh_error), Snackbar.LENGTH_SHORT).show();
                }
            });
        workitemsRequest.setTag(TAG);
        mRequestQueue.add(workitemsRequest);
    }

    @Override
    protected int getNoDataText() {
        return R.string.no_workitems;
    }

    @Override
    public void onStop() {
        super.onStop();
        mRequestQueue.cancelAll(TAG);
    }
}
