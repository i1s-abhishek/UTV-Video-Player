package com.abhishek.inplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.abhishek.xplayer.content.RecentMediaStorage;

public class VideoPlayListBean implements Parcelable {
    public static final Creator<VideoPlayListBean> CREATOR = new Creator<VideoPlayListBean>() {
        public VideoPlayListBean createFromParcel(Parcel parcel) {
            return new VideoPlayListBean(parcel);
        }

        public VideoPlayListBean[] newArray(int i) {
            return new VideoPlayListBean[i];
        }
    };

    public String f9813a;

    public long f9814b;

    public String f9815c;

    public long f9816d;

    public String f9817e;

    public RecentMediaStorage.ExInfo f9818f;

    public int f9819g;

    public int f9820h;

    public int describeContents() {
        return 0;
    }

    public VideoPlayListBean() {
        this.f9819g = -1;
        this.f9820h = -1;
    }

    private VideoPlayListBean(Parcel parcel) {
        this.f9819g = -1;
        this.f9820h = -1;
        this.f9813a = parcel.readString();
        this.f9814b = parcel.readLong();
        this.f9815c = parcel.readString();
        this.f9816d = parcel.readLong();
        this.f9817e = parcel.readString();
        this.f9818f = (RecentMediaStorage.ExInfo) parcel.readParcelable(RecentMediaStorage.ExInfo.class.getClassLoader());
        this.f9819g = parcel.readInt();
        this.f9820h = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9813a);
        parcel.writeLong(this.f9814b);
        parcel.writeString(this.f9815c);
        parcel.writeLong(this.f9816d);
        parcel.writeString(this.f9817e);
        parcel.writeParcelable(this.f9818f, i);
        parcel.writeInt(this.f9819g);
        parcel.writeInt(this.f9820h);
    }
}
