package com.abhishek.xplayer.content;

import android.os.Parcel;
import android.os.Parcelable;

import classesdef.xdplayer.axy;

public class MediaFileInfo implements Parcelable {
    public static final Creator<MediaFileInfo> CREATOR = new Creator<MediaFileInfo>() {
        /* renamed from: a */
        public MediaFileInfo createFromParcel(Parcel parcel) {
            return new MediaFileInfo(parcel);
        }

        /* renamed from: a */
        public MediaFileInfo[] newArray(int i) {
            return new MediaFileInfo[i];
        }
    };

    /* renamed from: a */
    public long f10496a;

    /* renamed from: b */
    public String f10497b;

    /* renamed from: c */
    private String f10498c;

    /* renamed from: d */
    private String f10499d;

    /* renamed from: e */
    private int f10500e;

    /* renamed from: f */
    private long f10501f;

    /* renamed from: g */
    private long f10502g;

    /* renamed from: h */
    private String f10503h;

    /* renamed from: i */
    private boolean f10504i;

    /* renamed from: j */
    private boolean f10505j;

    /* renamed from: k */
    private RecentMediaStorage.DBBean f10506k;

    public int describeContents() {
        return 0;
    }

    private MediaFileInfo(Parcel parcel) {
        this.f10501f = -1;
        this.f10503h = null;
        boolean z = false;
        this.f10504i = false;
        this.f10498c = parcel.readString();
        this.f10499d = parcel.readString();
        this.f10500e = parcel.readInt();
        this.f10501f = parcel.readLong();
        this.f10502g = parcel.readLong();
        this.f10503h = parcel.readString();
        this.f10504i = parcel.readByte() != 0;
        this.f10496a = parcel.readLong();
        this.f10505j = parcel.readByte() != 0 ? true : z;
        this.f10497b = parcel.readString();
        this.f10506k = (RecentMediaStorage.DBBean) parcel.readParcelable(RecentMediaStorage.DBBean.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10498c);
        parcel.writeString(this.f10499d);
        parcel.writeInt(this.f10500e);
        parcel.writeLong(this.f10501f);
        parcel.writeLong(this.f10502g);
        parcel.writeString(this.f10503h);
        parcel.writeByte(this.f10504i ? (byte) 1 : 0);
        parcel.writeLong(this.f10496a);
        parcel.writeByte(this.f10505j ? (byte) 1 : 0);
        parcel.writeString(this.f10497b);
        parcel.writeParcelable(this.f10506k, i);
    }

    /* renamed from: a */
    public void mo17883a(RecentMediaStorage.DBBean dBBean) {
        this.f10506k = dBBean;
        if (dBBean != null) {
            mo17882a(dBBean.f10534g);
        }
    }

    /* renamed from: a */
    public RecentMediaStorage.DBBean mo17880a() {
        return this.f10506k;
    }

    /* renamed from: b */
    public long mo17886b() {
        if (this.f10506k == null) {
            return 0;
        }
        return this.f10506k.f10533f;
    }

    /* renamed from: c */
    public boolean mo17889c() {
        return this.f10505j;
    }

    /* renamed from: a */
    public void mo17885a(boolean z) {
        this.f10505j = z;
    }

    public MediaFileInfo() {
        this.f10501f = -1;
        this.f10503h = null;
        this.f10504i = false;
    }

    /* renamed from: d */
    public String mo17890d() {
        return this.f10498c;
    }

    /* renamed from: a */
    public void mo17884a(String str) {
        this.f10498c = str;
        if (this.f10499d == null) {
            this.f10499d = axy.m7460a(str);
        }
    }

    /* renamed from: e */
    public String mo17892e() {
        return this.f10499d;
    }

    /* renamed from: b */
    public void mo17888b(String str) {
        this.f10499d = str;
    }

    /* renamed from: a */
    public void mo17881a(int i) {
        this.f10500e = i;
    }

    /* renamed from: a */
    public void mo17882a(long j) {
        this.f10501f = j;
        this.f10503h = axy.m7459a(j);
    }

    /* renamed from: f */
    public long mo17893f() {
        return this.f10501f;
    }

    /* renamed from: g */
    public String mo17894g() {
        return this.f10503h;
    }

    /* renamed from: h */
    public long mo17895h() {
        return this.f10502g;
    }

    /* renamed from: b */
    public void mo17887b(long j) {
        this.f10502g = j;
    }
}
