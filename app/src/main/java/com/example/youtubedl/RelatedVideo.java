
package com.example.youtubedl;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedVideo {

    @SerializedName("videoID")
    @Expose
    private String videoID;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("channelID")
    @Expose
    private String channelID;
    @SerializedName("channelName")
    @Expose
    private String channelName;
    @SerializedName("viewCount")
    @Expose
    private String viewCount;
    @SerializedName("duration")
    @Expose
    private String duration;

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
