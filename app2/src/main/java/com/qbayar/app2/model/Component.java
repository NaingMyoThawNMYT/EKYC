package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Component {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("refImageUrl")
    @Expose
    private String refImageUrl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Object getRefImageUrl() {
        return refImageUrl;
    }

    public void setRefImageUrl(String refImageUrl) {
        this.refImageUrl = refImageUrl;
    }
}
