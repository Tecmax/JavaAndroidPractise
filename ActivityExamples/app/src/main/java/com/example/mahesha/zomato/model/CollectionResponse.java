package com.example.mahesha.zomato.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionResponse {
    @SerializedName("collections")
    private List<ZomatoCollection> collections = null;
    @SerializedName("has_more")
    private Integer hasMore;
    @SerializedName("share_url")
    private String shareUrl;
    @SerializedName("display_text")
    private String displayText;
    @SerializedName("has_total")
    private Integer hasTotal;

    public List<ZomatoCollection> getCollections() {
        return collections;
    }

    public void setCollections(List<ZomatoCollection> collections) {
        this.collections = collections;
    }

    public Integer getHasMore() {
        return hasMore;
    }

    public void setHasMore(Integer hasMore) {
        this.hasMore = hasMore;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public Integer getHasTotal() {
        return hasTotal;
    }

    public void setHasTotal(Integer hasTotal) {
        this.hasTotal = hasTotal;
    }
}
