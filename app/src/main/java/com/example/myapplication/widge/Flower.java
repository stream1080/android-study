package com.example.myapplication.widge;

import android.os.Parcel;
import android.os.Parcelable;

public class Flower implements Parcelable {
    private int imageId;
    private String name;

    public Flower(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    protected Flower(Parcel in) {
        imageId = in.readInt();
        name = in.readString();
    }

    public static final Creator<Flower> CREATOR = new Creator<Flower>() {
        @Override
        //转换成类对象
        public Flower createFromParcel(Parcel in) {
            return new Flower(in);
        }

        @Override
        public Flower[] newArray(int size) {
            return new Flower[size];
        }
    };

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    //打包-序列化
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(name);
    }
}
