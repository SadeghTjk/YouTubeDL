
package com.danteh.youtubedl;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("videoID")
    @Expose
    private String videoID;
    @SerializedName("relatedVideo")
    @Expose
    private List<RelatedVideo> relatedVideo = null;
    @SerializedName("playerID")
    @Expose
    private String playerID;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("channelID")
    @Expose
    private String channelID;
    @SerializedName("channelName")
    @Expose
    private String channelName;
    @SerializedName("viewCount")
    @Expose
    private Integer viewCount;
    @SerializedName("subtitle")
    @Expose
    private Boolean subtitle;
    @SerializedName("video")
    @Expose
    private Video video;

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public List<RelatedVideo> getRelatedVideo() {
        return relatedVideo;
    }

    public void setRelatedVideo(List<RelatedVideo> relatedVideo) {
        this.relatedVideo = relatedVideo;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Boolean getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Boolean subtitle) {
        this.subtitle = subtitle;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

}
