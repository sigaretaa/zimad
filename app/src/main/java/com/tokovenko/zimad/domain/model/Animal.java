package com.tokovenko.zimad.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private String url;
    private String title;

    public Animal() {
    }


    public Animal(Parcel in) {
        url = in.readString();
        title = in.readString();
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(title);
    }

    public static final Parcelable.Creator<Animal> CREATOR = new Parcelable.Creator<Animal>() {

        @Override
        public Animal createFromParcel(Parcel source) {
            return new Animal(source);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    @Override
    public String toString() {
        return "Animal{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
