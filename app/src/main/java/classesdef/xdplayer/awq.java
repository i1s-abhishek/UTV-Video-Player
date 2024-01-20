package classesdef.xdplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;


import com.abhishek.xplayer.ad.C2226a;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

import classesdef.inplayer.axc;
import classesdef.inplayer.SharedPrefrence;
import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: awq */
public class awq {

    /* renamed from: a */
    protected Context f6119a;

    /* renamed from: b */
    protected int f6120b;

    /* renamed from: c */
    protected Uri f6121c;

    /* renamed from: d */
    protected Uri f6122d;

    /* renamed from: e */
    protected int f6123e;

    /* renamed from: f */
    protected int f6124f;

    /* renamed from: g */
    protected String f6125g;

    /* renamed from: h */
    protected String f6126h;

    /* renamed from: i */
    protected String f6127i;

    /* renamed from: j */
    protected String f6128j;

    /* renamed from: k */
    protected byte[] f6129k;

    /* renamed from: l */
    protected byte[] f6130l;

    /* renamed from: m */
    protected HashMap<String, JSONObject> f6131m = new HashMap<>();

    /* renamed from: awq$a */
    private class C1308a implements C2226a.C2227a {

        /* renamed from: b */
        private awq f6135b;

        /* renamed from: c */
        private boolean f6136c;

        public C1308a(awq awq, boolean z) {
            this.f6135b = awq;
            this.f6136c = z;
        }

        /* renamed from: a */
        public void mo16895a(byte[] bArr) {
            String str;
            if (bArr != null) {
                if (this.f6136c) {
                    this.f6135b.mo10879a(bArr);
                    str = "icon_cache_data" + awq.this.f6124f;
                } else {
                    this.f6135b.mo10882b(bArr);
                    str = "cover_cache_data" + awq.this.f6124f;
                }
                axc.m7300a(axy.cacheFolderAddresh(awq.this.f6119a), str, bArr);
            }
        }
    }

    public awq(Context context, JSONObject jSONObject) {
        this.f6119a = context;
        mo10878a(jSONObject);
        if (this.f6120b == 1 && this.f6121c != null && this.f6122d != null) {
            String b = axy.cacheFolderAddresh(this.f6119a);
            mo10879a(axc.m7302a(b, "icon_cache_data" + this.f6124f));
            String b2 = axy.cacheFolderAddresh(this.f6119a);
            mo10882b(axc.m7302a(b2, "cover_cache_data" + this.f6124f));
            if (this.f6129k == null) {
                axc.m7299a(context, axy.cacheFolderAddresh(this.f6119a), new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return str.startsWith("icon_cache_data");
                    }
                }, true);
                new C2226a(new C1308a(this, true)).execute(new String[]{this.f6121c.toString()});
            }
            if (this.f6130l == null) {
                axc.m7299a(context, axy.cacheFolderAddresh(this.f6119a), new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return str.startsWith("cover_cache_data");
                    }
                }, true);
                new C2226a(new C1308a(this, false)).execute(new String[]{this.f6122d.toString()});
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10878a(JSONObject jSONObject) {
        try {
            this.f6124f = jSONObject.getInt("update_ver");
            JSONObject jSONObject2 = jSONObject.getJSONObject("detail");
            int i = jSONObject2.getInt("dialogType");
            int i2 = jSONObject2.getInt("version");
            if (jSONObject2.has("iconImageUrl")) {
                this.f6121c = Uri.parse(jSONObject2.getString("iconImageUrl"));
            }
            if (jSONObject2.has("coverImageUrl")) {
                this.f6122d = Uri.parse(jSONObject2.getString("coverImageUrl"));
            }
            this.f6131m.putAll(axf.m7326a(jSONObject2.getJSONObject("language")));
            this.f6120b = i;
            this.f6123e = i2;
            JSONObject jSONObject3 = this.f6131m.get(String.valueOf(SharedPrefrence.language(this.f6119a)));
            if (jSONObject3 == null) {
                jSONObject3 = this.f6131m.get(String.valueOf(0));
            }
            if (jSONObject3 != null) {
                this.f6125g = jSONObject3.getString("title");
                this.f6126h = jSONObject3.getString("desc");
                this.f6127i = jSONObject3.getString("btnOK");
                this.f6128j = jSONObject3.getString("btnCancel");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public String mo10876a() {
        return this.f6125g != null ? this.f6125g : "";
    }

    /* renamed from: b */
    public String mo10880b() {
        return this.f6126h != null ? this.f6126h : "";
    }

    /* renamed from: c */
    public String mo10883c() {
        return this.f6127i != null ? this.f6127i : "";
    }

    /* renamed from: d */
    public String mo10884d() {
        return this.f6128j != null ? this.f6128j : "";
    }

    /* renamed from: a */
    public void mo10879a(byte[] bArr) {
        this.f6129k = bArr;
    }

    /* renamed from: b */
    public void mo10882b(byte[] bArr) {
        this.f6130l = bArr;
    }

    /* renamed from: e */
    public boolean mo10885e() {
        return this.f6129k != null;
    }

    /* renamed from: f */
    public boolean mo10886f() {
        return this.f6130l != null;
    }

    /* renamed from: g */
    public Bitmap mo10887g() {
        if (!(this.f6129k == null || this.f6129k.length == 1)) {
            try {
                return BitmapFactory.decodeByteArray(this.f6129k, 0, this.f6129k.length);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: h */
    public Bitmap mo10888h() {
        if (!(this.f6130l == null || this.f6130l.length == 1)) {
            try {
                return BitmapFactory.decodeByteArray(this.f6130l, 0, this.f6130l.length);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo10877a(ImageView imageView) {
        Bitmap g = mo10887g();
        if (g != null) {
            imageView.setImageBitmap(g);
        }
    }

    /* renamed from: b */
    public void mo10881b(ImageView imageView) {
        Bitmap h = mo10888h();
        if (h != null) {
            imageView.setImageBitmap(h);
        }
    }

    /* renamed from: i */
    public int mo10889i() {
        if (this.f6120b == 0) {
            return R.layout.show_upgraded_version_no_imgage_dlg;
        }
        if (this.f6120b != 1 || !mo10885e() || !mo10886f()) {
            return -1;
        }
        return R.layout.show_upgraded_version_with_imgage_dlg;
    }
}
