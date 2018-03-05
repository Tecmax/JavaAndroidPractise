package com.broadcast.softgen.broadcast;

/**
 * Created by Mahesh on 14-06-2017.
 */

public class IncomingNumber {
    private int id;
    private String number;

    public IncomingNumber(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
