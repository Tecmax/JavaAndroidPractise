package com.walmart.latest;

public class Student {
    private String stClass;
    private String stName;
    private String stSec;

    public Student(String name, String add, String Cla){
        stName=name;
        stClass=add;
        stSec=Cla;
    }

    public String getStClass() {
        return stClass;
    }

    public void setStClass(String stClass) {
        this.stClass = stClass;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStSec() {
        return stSec;
    }

    public void setStSec(String stSec) {
        this.stSec = stSec;
    }
}
