package com.ibm.rtc.rtc.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibm.rtc.rtc.R;
import com.ibm.rtc.rtc.model.Workitem;
import com.ibm.rtc.rtc.ui.base.TitleProvider;
import com.ibm.rtc.rtc.ui.base.WorkitembaseFragment;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.octicons_typeface_library.Octicons;

/**
 * Created by v-wajie on 1/6/2016.
 */
public class WorkitemDetailFragment extends WorkitembaseFragment implements TitleProvider {
    private static final String TAG = "WorkitemDetailFragment";


    private TextView summary;
    private TextView description;
    private TextView type;
    private TextView id;

    public static WorkitemDetailFragment newIntance(Workitem workitem) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(WORKITEM_INFO, workitem);
        WorkitemDetailFragment detailFragment = new WorkitemDetailFragment();
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_workitem_detail, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        summary = (TextView) view.findViewById(R.id.summary);
        description = (TextView) view.findViewById(R.id.description);
        type = (TextView) view.findViewById(R.id.type);
        id = (TextView) view.findViewById(R.id.workitem_id);

        setDisplayContent();
    }

    private void setDisplayContent() {
        summary.setText(getWorkitem().getTitle());
        description.setText(Html.fromHtml(getWorkitemDescription()));
        type.setText(getWorkitem().getType());
        id.setText(String.valueOf(getWorkitem().getId()));
    }

    private String getWorkitemDescription() {
        String description = getWorkitem().getDescription();
        if (description == null || description.isEmpty()) {
            description = getString(R.string.blank_description);
        }
        return "<h2>" + getString(R.string.workitem_description) + "</h2>"
                + description;
    }

    @Override
    public int getTitle() {
        return R.string.workitem_detail_title;
    }

    @Override
    public IIcon getTitleIcon() {
        return Octicons.Icon.oct_info;
    }
}
