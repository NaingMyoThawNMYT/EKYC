package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OkayDocMyKadResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("messageCode")
    @Expose
    private String messageCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("methodList")
    @Expose
    private List<Method> methodList = null;
    @SerializedName("outputImageList")
    @Expose
    private List<OutputImage> outputImageList = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }

    public List<OutputImage> getOutputImageList() {
        return outputImageList;
    }

    public void setOutputImageList(List<OutputImage> outputImageList) {
        this.outputImageList = outputImageList;
    }
}
