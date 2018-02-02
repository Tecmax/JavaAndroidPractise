package com.example.mahesha.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mahesh on 22-03-2017.
 */

public class MyParsable implements Parcelable {
    private int mData;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    public static final Parcelable.Creator<MyParsable> CREATOR
            = new Parcelable.Creator<MyParsable>() {
        public MyParsable createFromParcel(Parcel in) {
            return new MyParsable(in);
        }

        public MyParsable[] newArray(int size) {
            return new MyParsable[size];
        }
    };

    private MyParsable(Parcel in) {
        mData = in.readInt();
    }
}
