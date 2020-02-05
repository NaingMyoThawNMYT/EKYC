package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OutputImage {
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
