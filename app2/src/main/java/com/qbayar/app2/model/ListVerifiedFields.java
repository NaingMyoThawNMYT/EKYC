package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListVerifiedFields {
    @SerializedName("pFieldMaps")
    @Expose
    private List<PFieldMap> pFieldMaps = null;

    public List<PFieldMap> getPFieldMaps() {
        return pFieldMaps;
    }

    public void setPFieldMaps(List<PFieldMap> pFieldMaps) {
        this.pFieldMaps = pFieldMaps;
    }
}
