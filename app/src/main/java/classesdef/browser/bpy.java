package classesdef.browser;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/* renamed from: bpy */
abstract class bpy {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final long f16353a = TimeUnit.DAYS.toSeconds(1);

    /* renamed from: f Interceptor */
    private static final Interceptor f16354f = new Interceptor() {
        /* renamed from: a */
        public Response intercept(Interceptor.Chain aVar) throws IOException {
            Response.Builder i = aVar.proceed(aVar.request()).newBuilder();
            return i.addHeader("cache-control", "max-age=" + bpy.f16353a + ", max-stale=" + bpy.f16353a).build();
        }
    };

    /* renamed from: b */
    private final OkHttpClient f16355b;

    /* renamed from: c */
    private final  CacheControl f16356c;

    /* renamed from: d */
    private final String f16357d;

    /* renamed from: e */
    private final String f16358e = m18866b();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo23530a(String str, String str2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo23531a(InputStream inputStream, List<bmg> list) throws XmlPullParserException, IOException, JSONException;

    bpy(Application application, String str) {
        this.f16357d = str;
        this.f16355b = new  OkHttpClient.Builder().cache(new Cache(new File(application.getCacheDir(), "suggestion_responses"), bqi.m18945a(1))).addNetworkInterceptor(f16354f).build();
        this.f16356c = new CacheControl.Builder().maxStale(1, TimeUnit.DAYS).build();
    }

    /* renamed from: b */
    private static String m18866b() {
        String language = Locale.getDefault().getLanguage();
        return TextUtils.isEmpty(language) ? "en" : language;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<bmg> mo23532a(String str) {
        ArrayList arrayList = new ArrayList(5);
        try {
            str = URLEncoder.encode(str, this.f16357d);
        } catch (UnsupportedEncodingException e) {
            Log.e("BaseSuggestionsModel", "Unable to encode the URL", e);
        }
        InputStream b = m18865b(str, this.f16358e);
        if (b == null) {
            return arrayList;
        }
        try {
            mo23531a(b, (List<bmg>) arrayList);
            return arrayList;
        } catch (Exception e2) {
            Log.e("BaseSuggestionsModel", "Unable to parse results", e2);
            return arrayList;
        } finally {
            bqw.m19016a((Closeable) b);
        }
    }

    /* renamed from: b */
    private InputStream m18865b(String str, String str2) {
        try {
            ResponseBody h = this.f16355b.newCall(new Request.Builder().url(new URL(mo23530a(str, str2))).addHeader("Accept-Charset", this.f16357d).cacheControl(this.f16356c).build()).execute().body();
            if (h != null) {
                return h.byteStream();
            }
            return null;
        } catch (IOException e) {
            Log.e("BaseSuggestionsModel", "Problem getting search suggestions", e);
            return null;
        }
    }
}
