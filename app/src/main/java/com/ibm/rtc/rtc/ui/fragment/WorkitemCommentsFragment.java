package com.ibm.rtc.rtc.ui.fragment;

import android.os.Bundle;

import com.ibm.rtc.rtc.R;
import com.ibm.rtc.rtc.ui.base.TitleProvider;
import com.ibm.rtc.rtc.ui.base.WorkitembaseFragment;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.octicons_typeface_library.Octicons;

/**
 * Created by v-wajie on 1/6/2016.
 */
public class WorkitemCommentsFragment extends WorkitembaseFragment implements TitleProvider {


    public static WorkitemCommentsFragment newInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(WORKITEM_ID, id);

        WorkitemCommentsFragment commentsFragment = new WorkitemCommentsFragment();
        commentsFragment.setArguments(bundle);
        return commentsFragment;
    }

    @Override
    public int getTitle() {
        return R.string.workitem_comment_title;
    }

    @Override
    public IIcon getTitleIcon() {
        return Octicons.Icon.oct_comment_discussion;
    }
}
