package com.ibm.rtc.rtc.core;

import com.ibm.rtc.rtc.model.Workitem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pampas Eagle on 2016/1/16.
 */
public class WorkitemFilter {

    public static List<Workitem> filter(List<Workitem> workitemList, List<String> types) {

        List<Workitem> result = new ArrayList<Workitem>();
        // 如果筛选条件为空，则直接返回原本list
        if (types == null) {
            return workitemList;
        }
        if (types.size() == 0) {
            return workitemList;
        }
        // 根据筛选条件返回满足条件的list
        for (Workitem workitem : workitemList) {
            if (types.contains(workitem.getTypeIndentifier().name())) {
                result.add(workitem);
            }
        }
        return result;
    }
}

