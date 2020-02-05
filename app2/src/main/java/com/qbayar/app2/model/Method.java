package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Method {
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("componentList")
    @Expose
    private List<Component> componentList = null;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }
}
