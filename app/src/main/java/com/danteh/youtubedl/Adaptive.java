
package com.danteh.youtubedl;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Adaptive {

    @SerializedName("itag")
    @Expose
    private String itag;
    @SerializedName("type")
    @Expose
    private List<String> type = null;
    @SerializedName("expire")
    @Expose
    private String expire;
    @SerializedName("quality")
    @Expose
    private String quality;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("P-url")
    @Expose
    private String pUrl;

    public String getItag() {
        return itag;
    }

    public void setItag(String itag) {
        this.itag = itag;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPUrl() {
        return pUrl;
    }

    public void setPUrl(String pUrl) {
        this.pUrl = pUrl;
    }

}
