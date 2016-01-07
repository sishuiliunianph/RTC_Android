package com.ibm.rtc.rtc.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-wajie on 1/6/2016.
 */
public class Project implements Parcelable {
    private String title;
    private String uuid;
    private String description;

    private Project() {}

    public static List<Project> fromJSONArray(JSONArray jsonArray) throws JSONException {
        List<Project> projectList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject object = jsonArray.getJSONObject(i);
            projectList.add(fromJSON(object));
        }
        return projectList;
    }

    public static Project fromJSON(JSONObject object) throws JSONException {
        Project project = new Project();
        project.setTitle(object.getString("title"));
        project.setUuid(object.getString("uuid"));
        return project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>() {

        @Override
        public Project createFromParcel(Parcel source) {
            return new Project(source);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(uuid);
        dest.writeString(description);
    }

    private Project(Parcel in) {
        title = in.readString();
        uuid = in.readString();
        description = in.readString();
    }
}
