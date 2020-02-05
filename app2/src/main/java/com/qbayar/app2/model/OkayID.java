package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OkayID {
    @SerializedName("base64ImageString")
    @Expose
    private String base64ImageString;
    @SerializedName("backImage")
    @Expose
    private String backImage;
    @SerializedName("apiKey")
    @Expose
    private String apiKey;
    @SerializedName("imageFormat")
    @Expose
    private String imageFormat;
    @SerializedName("imageEnabled")
    @Expose
    private boolean imageEnabled;

    public String getBase64ImageString() {
        return base64ImageString;
    }

    public void setBase64ImageString(String base64ImageString) {
        this.base64ImageString = base64ImageString;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public boolean isImageEnabled() {
        return imageEnabled;
    }

    public void setImageEnabled(boolean imageEnabled) {
        this.imageEnabled = imageEnabled;
    }
}
