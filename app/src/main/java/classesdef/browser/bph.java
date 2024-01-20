package classesdef.browser;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.Serializable;


public class bph implements Serializable {


    private long f16142a;


    private String f16143b = "";


    private String f16144c = "";


    private long f16145d;


    private String f16146e = "";

    private String file_dir_save_location = "";


    private int f16148g;


    private int f16149h;


    private long video_length;

    private String video_thumbnail;


    private long videoSize;


    private boolean f16153l;


    private boolean f16154m;

    private int f16155n;


    private String cookies = "";


    private String user_agent = "";

    private String f16422q = "";

    public void mo23331a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Log.e("video_length","__"+String.valueOf(jSONObject));
                mo23344d(jSONObject.optLong("video_length", 0));
                mo23349f(jSONObject.optString("video_thumbnail", ""));
                mo23345d(jSONObject.optString("file_dir", ""));
                mo23351g(jSONObject.optString("cookies", ""));
                mo23353h(jSONObject.optString("user_agent", ""));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public String mo23328a() {
        try {
            Log.e("video_length1","__"+String.valueOf("call"));
            JSONObject jSONObject = new JSONObject();
            Log.e("video_length2","__"+String.valueOf( jSONObject));
            jSONObject.put("video_length", mo23360o());
            Log.e("video_length3","__"+String.valueOf( mo23360o()));
            jSONObject.put("video_thumbnail", mo23361p());
            jSONObject.put("file_dir", mo23350g());
            jSONObject.put("cookies", mo23362q());
            jSONObject.put("user_agent", mo23363r());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }


    public File mo23327a(Context context) {
        if (TextUtils.isEmpty(this.file_dir_save_location)) {
            return new File(boo.m18378b(context), mo23346e());
        }
        File file = new File(this.file_dir_save_location);
        if (!file.exists() || !file.canWrite()) {
            return new File(boo.m18378b(context), mo23346e());
        }
        return new File(this.file_dir_save_location, mo23346e());
    }


    public String mo23334b(Context context) {
        return mo23327a(context).getAbsolutePath();
    }


    public long mo23333b() {
        return this.f16142a;
    }


    public void mo23330a(long j) {
        this.f16142a = j;
    }


    public String mo23339c() {
        return this.f16143b == null ? "" : this.f16143b;
    }


    public void mo23337b(String str) {
        this.f16143b = str;
    }


    public long mo23343d() {
        return this.f16145d;
    }


    public void mo23336b(long j) {
        this.f16145d = j;
    }


    public String mo23346e() {
        return this.f16146e == null ? "" : this.f16146e;
    }


    public String mo23348f() {
        if (TextUtils.isEmpty(this.f16146e)) {
            return "";
        }
        try {
            return this.f16146e;
           // return blc.m17790a(this.f16146e);
        } catch (Exception e) {
            e.printStackTrace();
            return this.f16146e;
        }
    }


    public void mo23342c(String str) {
        this.f16146e = str;
    }


    public String mo23350g() {
        return this.file_dir_save_location;
    }


    public void mo23345d(String str) {
        this.file_dir_save_location = str;
    }


    public int mo23352h() {
        return this.f16148g;
    }

    public void mo23329a(int i) {
        this.f16148g = i;
    }


    public String mo23354i() {
        return this.f16144c;
    }

    public void mo23347e(String str) {
        this.f16144c = str;
    }

    public int mo23355j() {
        return this.f16149h;
    }


    public void mo23335b(int i) {
        this.f16149h = i;
    }


    public boolean mo23356k() {
        return this.f16153l;
    }


    public void mo23332a(boolean z) {
        this.f16153l = z;
    }


    public synchronized long getVideoSize() {
        return this.videoSize;
    }


    public synchronized void setVideoSize(long j) {
        this.videoSize = j;
    }


    public boolean mo23358m() {
        return this.f16154m;
    }


    public void mo23338b(boolean z) {
        this.f16154m = z;
    }


    public int mo23359n() {
        return this.f16155n;
    }


    public void mo23340c(int i) {
        this.f16155n = i;
    }


    public long mo23360o() {
        return this.video_length;
    }


    public void mo23344d(long j) {
        this.video_length = j;
    }


    public String mo23361p() {
        return this.video_thumbnail;
    }


    public void mo23349f(String str) {
        this.video_thumbnail = str;
    }


    public String mo23362q() {
        return this.cookies;
    }


    public void mo23351g(String str) {
        this.cookies = str;
    }


    public String mo23363r() {
        return this.user_agent;
    }


    public void mo23353h(String str) {
        this.user_agent = str;
    }

    public String mo24644s() {
        if (TextUtils.isEmpty(this.f16422q)) {
            return this.f16144c;
        }
        return this.f16422q;
    }
}
