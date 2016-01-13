package com.ibm.rtc.rtc.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.ibm.rtc.rtc.R;
import com.ibm.rtc.rtc.model.Workitem;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.octicons_typeface_library.Octicons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by v-wajie on 1/13/2016.
 */
public class AttributeItemViewListBuilder {
    private final Workitem workitem;
    private final Context context;
    private final ViewGroup parent;
    private List<View> viewList;

    public AttributeItemViewListBuilder(Context context, Workitem workitem, ViewGroup parent) {
        this.context = context;
        this.workitem = workitem;
        this.parent = parent;
        viewList = new ArrayList<>();
    }

    public AttributeItemViewListBuilder addType(View.OnClickListener listener) {
        viewList.add(
                new AttributeItem(Octicons.Icon.oct_tag, context.getString(R.string.workitem_type)
                       + " " + workitem.getType(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addOwnedBy(View.OnClickListener listener) {
        viewList.add(
                new AttributeItem(Octicons.Icon.oct_person, context.getString(R.string.workitem_ownedBy)
                        + " " + workitem.getOwnedBy(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addFiledAgainst(View.OnClickListener listener) {
        viewList.add(
                new AttributeItem(Octicons.Icon.oct_file_directory, context.getString(R.string.workitem_fileAgainst)
                        + " " + workitem.getFiledAgainst(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addCreatedBy(View.OnClickListener listener) {
        if (workitem.getCreatedBy() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(Octicons.Icon.oct_person, context.getString(R.string.workitem_createdBy)
                        + " " + workitem.getCreatedBy(), listener).getView(context, parent));
        return this;
    }


    public AttributeItemViewListBuilder addFoundIn(View.OnClickListener listener) {
        if (workitem.getFoundIn() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(Octicons.Icon.oct_primitive_square, context.getString(R.string.workitem_foundIn)
                        + " " + workitem.getFoundIn(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addPriority(View.OnClickListener listener) {
        viewList.add(
                new AttributeItem(Octicons.Icon.oct_alert, context.getString(R.string.workitem_priority)
                        + " " + workitem.getPriority(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addSeverity(View.OnClickListener listener) {
        viewList.add(
                new AttributeItem(Octicons.Icon.oct_bell, context.getString(R.string.workitem_severity)
                        + " " + workitem.getSeverity(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addEstimateTime(View.OnClickListener listener) {
        long time = workitem.getEstimate();
        if (time < 0) {
            listener = null;
            return this;
        }

        viewList.add(
                new AttributeItem(Octicons.Icon.oct_calendar, context.getString(R.string.workitem_estimate)
                        + " " + toTimePeriod(time), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addTimeSpent(View.OnClickListener listener) {
        long time = workitem.getTimeSpent();
        if (time < 0) {
            listener = null;
            return this;
        }

        viewList.add(
                new AttributeItem(Octicons.Icon.oct_calendar, context.getString(R.string.workitem_timeSpent)
                        + " " + toTimePeriod(time), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addCreatedTime(View.OnClickListener listener) {
        if (workitem.getCreatedTime() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(GoogleMaterial.Icon.gmd_access_time, context.getString(R.string.workitem_createdTime)
                        + " " + workitem.getCreatedTime().toString(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addLastModifiedTime(View.OnClickListener listener) {
        if (workitem.getLastModifiedTime() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(GoogleMaterial.Icon.gmd_create, context.getString(R.string.workitem_modifiedTime)
                        + " " + workitem.getLastModifiedTime().toString(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addDueDate(View.OnClickListener listener) {
        if (workitem.getDueDate() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(GoogleMaterial.Icon.gmd_access_alarm, context.getString(R.string.workitem_dueDate)
                        + " " + workitem.getDueDate().toString(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addPlannedFor(View.OnClickListener listener) {
        if (workitem.getPlannedFor() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(GoogleMaterial.Icon.gmd_dashboard, context.getString(R.string.workitem_plannedFor)
                        + " " + workitem.getPlannedFor(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addBusinessValue(View.OnClickListener listener) {
        if (workitem.getBusinessValue() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(GoogleMaterial.Icon.gmd_equalizer, context.getString(R.string.workitem_businessValue)
                        + " " + workitem.getBusinessValue(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addRisk(View.OnClickListener listener) {
        if (workitem.getRisk() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(GoogleMaterial.Icon.gmd_assignment_late, context.getString(R.string.workitem_risk)
                        + " " + workitem.getRisk(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addImpact(View.OnClickListener listener) {
        if (workitem.getImpact() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(GoogleMaterial.Icon.gmd_gradient, context.getString(R.string.workitem_impact)
                        + " " + workitem.getImpact(), listener).getView(context, parent));
        return this;
    }

    public AttributeItemViewListBuilder addStoryPoint(View.OnClickListener listener) {
        if (workitem.getStoryPoint() == null) {
            listener = null;
            return this;
        }
        viewList.add(
                new AttributeItem(GoogleMaterial.Icon.gmd_insert_chart, context.getString(R.string.workitem_storyPoint)
                        + " " + workitem.getStoryPoint(), listener).getView(context, parent));
        return this;
    }

    public List<View> build() {
        return viewList;
    }

    private String toTimePeriod(long time) {
        return new Date(time).toString();
    }
}
