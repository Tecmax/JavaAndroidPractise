package com.tecmax.basicappli;

/**
 * Created by DELL PC on 21-Dec-17.
 */

public class Product {
    private String name;
    private double mrp;
    private double sp;
    private Integer image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getSp() {
        return sp;
    }

    public void setSp(double sp) {
        this.sp = sp;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
