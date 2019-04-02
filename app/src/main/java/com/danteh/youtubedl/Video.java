
package com.danteh.youtubedl;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("encoded")
    @Expose
    private List<Encoded> encoded = null;
    @SerializedName("adaptive")
    @Expose
    private List<Adaptive> adaptive = null;

    public List<Encoded> getEncoded() {
        return encoded;
    }

    public void setEncoded(List<Encoded> encoded) {
        this.encoded = encoded;
    }

    public List<Adaptive> getAdaptive() {
        return adaptive;
    }

    public void setAdaptive(List<Adaptive> adaptive) {
        this.adaptive = adaptive;
    }

}
