package com.example.mahesha.zomato.model;

import com.google.gson.annotations.SerializedName;

public class ZomatoCollection {
    @SerializedName("collection")
    private CollectionList collection;

    public CollectionList getCollection() {
        return collection;
    }

    public void setCollection(CollectionList collection) {
        this.collection = collection;
    }
}
