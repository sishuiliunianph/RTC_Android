package com.ibm.rtc.rtc.model;

/**
 * Created by v-wajie on 1/13/2016.
 */
public enum WorkitemType {
    Defect("defect"),
    Task("task"),
    Story("com.ibm.team.apt.workItemType.story"),
    Epic("com.ibm.team.apt.workItemType.epic"),
    BuildTracking("com.ibm.team.workItemType.buildtrackingitem"),
    Impediment("com.ibm.team.workitem.workItemType.impediment"),
    Adoption("com.ibm.team.workItemType.adoption"),
    Retrospective("com.ibm.team.workitem.workItemType.retrospective");

    public static WorkitemType getType(String value) {
        for (WorkitemType type : WorkitemType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException(value + "must be a kind of workitem type");
    }

    private String value;
    private WorkitemType(String type) {
        this.value = type;
    }
    public String getValue() {
        return value;
    }
}
