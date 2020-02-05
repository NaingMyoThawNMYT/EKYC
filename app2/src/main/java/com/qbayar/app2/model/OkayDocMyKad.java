package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OkayDocMyKad {
    @SerializedName("apiKey")
    @Expose
    private String apiKey;
    @SerializedName("idImageBase64Image")
    @Expose
    private String idImageBase64Image;
    @SerializedName("idNumber")
    @Expose
    private String idNumber;
    @SerializedName("otherDocList")
    @Expose
    private List<OtherDoc> otherDoc = null;
    @SerializedName("photoSubstitutionCheck")
    @Expose
    private Boolean photoSubstitutionCheck;
    @SerializedName("edgeDetection")
    @Expose
    private Boolean edgeDetection;
    @SerializedName("fontCheck")
    @Expose
    private Boolean fontCheck;
    @SerializedName("hologram")
    @Expose
    private Boolean hologram;
    @SerializedName("colorMode")
    @Expose
    private Boolean colorMode;
    @SerializedName("icTypeCheck")
    @Expose
    private Boolean icTypeCheck;
    @SerializedName("landmarkCheck")
    @Expose
    private Boolean landmarkCheck;
    @SerializedName("microprintCheck")
    @Expose
    private Boolean microprintCheck;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getIdImageBase64Image() {
        return idImageBase64Image;
    }

    public void setIdImageBase64Image(String idImageBase64Image) {
        this.idImageBase64Image = idImageBase64Image;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<OtherDoc> getOtherDoc() {
        return otherDoc;
    }

    public void setOtherDoc(List<OtherDoc> otherDoc) {
        this.otherDoc = otherDoc;
    }

    public Boolean getPhotoSubstitutionCheck() {
        return photoSubstitutionCheck;
    }

    public void setPhotoSubstitutionCheck(Boolean photoSubstitutionCheck) {
        this.photoSubstitutionCheck = photoSubstitutionCheck;
    }

    public Boolean getEdgeDetection() {
        return edgeDetection;
    }

    public void setEdgeDetection(Boolean edgeDetection) {
        this.edgeDetection = edgeDetection;
    }

    public Boolean getFontCheck() {
        return fontCheck;
    }

    public void setFontCheck(Boolean fontCheck) {
        this.fontCheck = fontCheck;
    }

    public Boolean getHologram() {
        return hologram;
    }

    public void setHologram(Boolean hologram) {
        this.hologram = hologram;
    }

    public Boolean getColorMode() {
        return colorMode;
    }

    public void setColorMode(Boolean colorMode) {
        this.colorMode = colorMode;
    }

    public Boolean getIcTypeCheck() {
        return icTypeCheck;
    }

    public void setIcTypeCheck(Boolean icTypeCheck) {
        this.icTypeCheck = icTypeCheck;
    }

    public Boolean getLandmarkCheck() {
        return landmarkCheck;
    }

    public void setLandmarkCheck(Boolean landmarkCheck) {
        this.landmarkCheck = landmarkCheck;
    }

    public Boolean getMicroprintCheck() {
        return microprintCheck;
    }

    public void setMicroprintCheck(Boolean microprintCheck) {
        this.microprintCheck = microprintCheck;
    }
}
