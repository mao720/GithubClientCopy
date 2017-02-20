package com.jhlc5173.githubclientcopy.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/17.
 */

public class Repository implements Parcelable {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_BIG = 1;
    public static final int TYPE_FEATURED = 2;
    public long id;
    public String name;
    public String url;
    public int stargazers_count;
    public int forks_count;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeInt(this.stargazers_count);
        dest.writeInt(this.forks_count);
    }

    public Repository() {
    }

    protected Repository(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.url = in.readString();
        this.stargazers_count = in.readInt();
        this.forks_count = in.readInt();
    }

    public static final Parcelable.Creator<Repository> CREATOR = new Parcelable.Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel source) {
            return new Repository(source);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };
}
