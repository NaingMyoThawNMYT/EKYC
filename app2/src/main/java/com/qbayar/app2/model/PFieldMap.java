package com.qbayar.app2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PFieldMap {
    @SerializedName("wLCID")
    @Expose
    private double wLCID;
    @SerializedName("FieldType")
    @Expose
    private double fieldType;
    @SerializedName("wFieldType")
    @Expose
    private double wFieldType;
    @SerializedName("Field_MRZ")
    @Expose
    private String fieldMRZ;
    @SerializedName("Field_Visual")
    @Expose
    private String fieldVisual;
    @SerializedName("Matrix")
    @Expose
    private List<Double> matrix = null;

    public double getwLCID() {
        return wLCID;
    }

    public void setwLCID(double wLCID) {
        this.wLCID = wLCID;
    }

    public double getFieldType() {
        return fieldType;
    }

    public void setFieldType(double fieldType) {
        this.fieldType = fieldType;
    }

    public double getwFieldType() {
        return wFieldType;
    }

    public void setwFieldType(double wFieldType) {
        this.wFieldType = wFieldType;
    }

    public String getFieldMRZ() {
        return fieldMRZ;
    }

    public void setFieldMRZ(String fieldMRZ) {
        this.fieldMRZ = fieldMRZ;
    }

    public String getFieldVisual() {
        return fieldVisual;
    }

    public void setFieldVisual(String fieldVisual) {
        this.fieldVisual = fieldVisual;
    }

    public List<Double> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<Double> matrix) {
        this.matrix = matrix;
    }
}
