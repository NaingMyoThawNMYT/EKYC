package com.qbayar.app2.model;

import java.io.Serializable;

public class OkayID implements Serializable {
    private String base64ImageString;
    private String backImage;
    private String apiKey;
    private String imageFormat;
    private boolean imageEnabled;

    public void setBase64ImageString(String base64ImageString) {
        this.base64ImageString = base64ImageString;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public void setImageEnabled(boolean imageEnabled) {
        this.imageEnabled = imageEnabled;
    }
}
