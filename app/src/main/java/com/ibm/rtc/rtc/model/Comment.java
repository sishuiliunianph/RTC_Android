package com.ibm.rtc.rtc.model;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mubai on 2016/1/11.
 */
public class Comment implements Parcelable {
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

    private String creator;
    private Image avatar;
    private String description;
    private Date createdTime;

    private int projectId;
    private int id;

    public Comment() {}

    public static List<Comment> fromJSONArray(JSONArray jsonArray) throws JSONException, ParseException {
        List<Workitem> workitemList = new ArrayList<>();
        //workitemList => JSONArray
        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject object = jsonArray.getJSONObject(i);
            workitemList.add(fromJSON(object));
        }
        return workitemList;
    }

    protected Comment(Parcel in) {
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
