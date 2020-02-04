package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("Base64ImageString")
    @Expose
    private String base64ImageString;
    @SerializedName("Format")
    @Expose
    private String format;
    @SerializedName("LightIndex")
    @Expose
    private Integer lightIndex;
    @SerializedName("PageIndex")
    @Expose
    private Integer pageIndex;

    public String getBase64ImageString() {
        return base64ImageString;
    }

    public void setBase64ImageString(String base64ImageString) {
        this.base64ImageString = base64ImageString;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getLightIndex() {
        return lightIndex;
    }

    public void setLightIndex(Integer lightIndex) {
        this.lightIndex = lightIndex;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}
