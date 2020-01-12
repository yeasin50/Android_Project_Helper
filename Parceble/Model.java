package com.example.parceble;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    private int image;
    private String text1;
    private String text2;

    public Model(int image, String text1, String text2) {
        this.image = image;
        this.text1 = text1;
        this.text2 = text2;
    }

    protected Model(Parcel in) {
        image = in.readInt();
        text1 = in.readString();
        text2 = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public int getImage() {
        return image;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(text1);
        dest.writeString(text2);
    }
}
