package com.example.jessi.rjtaberfitch.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PromoCardModel {

    @SerializedName("title")
    private String title;
    @SerializedName("backgroundImage")
    private String backgroundImage;
    @SerializedName("content")
    private List<ContentObject> contentObjects;
    @SerializedName("promoMessage")
    private String promoMessage;
    @SerializedName("topDescription")
    private String topDescription;
    @SerializedName("bottomDescription")
    private String bottomDescription;

    public PromoCardModel() {
    }

    public PromoCardModel(String title, String imageUrl, List<ContentObject> contentObjectList, String promoMessage, String topDescription, String bottomDescription) {
        this.title = title;
        this.backgroundImage = imageUrl;
        this.contentObjects = contentObjectList;
        this.promoMessage = promoMessage;
        this.topDescription = topDescription;
        this.bottomDescription = bottomDescription;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return backgroundImage;
    }

    public void setImageUrl(String imageUrl) {
        this.backgroundImage = imageUrl;
    }

    public List<ContentObject> getContentObjects() {
        return contentObjects;
    }

    public void setContentObjects(List<ContentObject> contentObjects) {
        this.contentObjects = contentObjects;
    }

    public String getPromoMessage() {
        return promoMessage;
    }

    public void setPromoMessage(String promoMessage) {
        this.promoMessage = promoMessage;
    }

    public String getTopDescription() {
        return topDescription;
    }

    public void setTopDescription(String topDescription) {
        this.topDescription = topDescription;
    }

    public String getBottomDescription() {
        return bottomDescription;
    }

    public void setBottomDescription(String bottomDescription) {
        this.bottomDescription = bottomDescription;
    }
}
