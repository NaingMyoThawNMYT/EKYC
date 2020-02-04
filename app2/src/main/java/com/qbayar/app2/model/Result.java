package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {
    @SerializedName("ListVerifiedFields")
    @Expose
    private ListVerifiedFields listVerifiedFields;

    public ListVerifiedFields getListVerifiedFields() {
        return listVerifiedFields;
    }

    public void setListVerifiedFields(ListVerifiedFields listVerifiedFields) {
        this.listVerifiedFields = listVerifiedFields;
    }
}
