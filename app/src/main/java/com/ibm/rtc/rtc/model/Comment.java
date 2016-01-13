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

    public Comment() {}

    //测试用构造函数
    public Comment(String creator, Date createdTime, String description) {
        this.creator = creator;
        this.createdTime = createdTime;
        this.description = description;
    }

    public static List<Comment> fromJSONArray(JSONArray jsonArray) throws JSONException, ParseException {
        List<Comment> commentList = new ArrayList<>();
        //commentList => JSONArray
        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject object = jsonArray.getJSONObject(i);
            commentList.add(fromJSON(object));
        }
        return commentList;
    }

    public static Comment fromJSON(JSONObject object) throws JSONException, ParseException {
        Comment comment = new Comment();
        comment.setCreator(object.getString("creator"));
        // TODO: 2016/1/12 add avatar
        comment.setDescription(object.getString("description"));

        if (!object.getString("createdTime").equals("null")) {
            comment.setCreatedTime(dateFormat.parse(object.getString("createdTime")));
        } else {
            comment.setCreatedTime(null);
        }

        return comment;
    }

    //Getter
    public String getCreator() {
        return creator;
    }

    public Image getAvatar() {
        return avatar;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    //Setter
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(creator);
        dest.writeLong(createdTime == null ? -1 : createdTime.getTime());
        // TODO: 2016/1/12 add avatar
        dest.writeString(description);

    }

    public static final Parcelable.Creator<Comment> CREATOR = new Parcelable.Creator<Comment>() {

        @Override
        public Comment createFromParcel(Parcel source) {
            return new Comment(source);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    private Comment(Parcel in) {
        creator = in.readString();
        Long peek;
        createdTime = (peek = in.readLong()) >= 0 ? new Date(peek) : null;
        // TODO: 2016/1/12 add avatar
        description = in.readString();
    }
}
