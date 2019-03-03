package com.example.mahesha.zomato.model;

import com.google.gson.annotations.SerializedName;

public class CollectionList {
    @SerializedName("collection_id")
    private Integer collectionId;
    @SerializedName("res_count")
    private Integer resCount;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("url")
    private String url;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("share_url")
    private String shareUrl;

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getResCount() {
        return resCount;
    }

    public void setResCount(Integer resCount) {
        this.resCount = resCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

}
