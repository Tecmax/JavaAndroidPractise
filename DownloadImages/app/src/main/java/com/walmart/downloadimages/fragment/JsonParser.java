package com.walmart.downloadimages.fragment;

import java.util.ArrayList;

public class JsonParser {
    private ArrayList<Collections> collections;
    private String displayText;
    private String shareUrl;
    private int hasMore;
    private int hasTotal;

    public int getHasTotal() {
        return hasTotal;
    }

    public void setHasTotal(int hasTotal) {
        this.hasTotal = hasTotal;
    }

    public int getHasMore() {
        return hasMore;
    }

    public void setHasMore(int hasMore) {
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

    public ArrayList<Collections> getCollections() {
        return collections;
    }

    public void setCollections(ArrayList<Collections> collections) {
        this.collections = collections;
    }
}
