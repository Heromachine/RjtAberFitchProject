package com.example.jessi.rjtaberfitch.data.models;

import com.google.gson.annotations.SerializedName;

public class ContentObject {

    @SerializedName("target")
    private String target;
    @SerializedName("title")
    private String title;
    @SerializedName("elementType")
    private  String elementType;

    public ContentObject() {
    }

    public ContentObject(String target, String title, String elementType) {
        this.target = target;
        this.title = title;
        this.elementType = elementType;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
