package classesdef.browser;

import com.liulishuo.filedownloader.connection.FileDownloadConnection;
import com.liulishuo.filedownloader.util.FileDownloadHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* renamed from: a */
public class C0000a implements FileDownloadConnection {

    /* renamed from: a */
    final OkHttpClient f0a;

    /* renamed from: b */
    private final Request.Builder f1b;

    /* renamed from: c */
    private Request f2c;

    /* renamed from: d */
    private Response f3d;

    /* renamed from: a */
    public boolean dispatchAddResumeOffset(String str, long j) {
        return false;
    }

    C0000a(Request.Builder aVar, OkHttpClient bhs) {
        this.f1b = aVar;
        this.f0a = bhs;
    }

    public C0000a(String str, OkHttpClient bhs) {
        this(new  Request.Builder().url(str), bhs);
    }

    /* renamed from: a */
    public void addHeader(String str, String str2) {
        this.f1b.addHeader(str, str2);
    }

    /* renamed from: a */
    public InputStream getInputStream() throws IOException {
        if (this.f3d == null) {
            throw new IOException("Please invoke #execute first!");
        }
        ResponseBody h = this.f3d.body();
        if (h != null) {
            return h.byteStream();
        }
        throw new IOException("No body found on response!");
    }

    /* renamed from: b */
    public Map<String, List<String>> getRequestHeaderFields() {
        if (this.f2c == null) {
            this.f2c = this.f1b.build();
        }
        return this.f2c.headers().toMultimap();
    }

    /* renamed from: c */
    public Map<String, List<String>> getResponseHeaderFields() {
        if (this.f3d == null) {
            return null;
        }
        return this.f3d.headers().toMultimap();
    }

    /* renamed from: a */
    public String getResponseHeaderField(String str) {
        if (this.f3d == null) {
            return null;
        }
        return this.f3d.header(str);
    }

    /* renamed from: b */
    public boolean setRequestMethod(String str) {
        this.f1b.method(str,  null);
        return true;
    }

    /* renamed from: d */
    public void execute() throws IOException {
        if (this.f2c == null) {
            this.f2c = this.f1b.build();
        }
        this.f3d = this.f0a.newCall(this.f2c).execute();
    }

    /* renamed from: e */
    public int getResponseCode() {
        if (this.f3d != null) {
            return this.f3d.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    /* renamed from: f */
    public void ending() {
        this.f2c = null;
        this.f3d = null;
    }

    /* renamed from: a$a */
    public static class C0001a implements FileDownloadHelper.ConnectionCreator {

        /* renamed from: a */
        private OkHttpClient f4a;

        /* renamed from: b */
        private OkHttpClient.Builder f5b;

        public C0001a() {
        }

        public C0001a(OkHttpClient.Builder aVar) {
            this.f5b = aVar;
        }

        /* renamed from: a */
        public FileDownloadConnection create(String str) {
            if (this.f4a == null) {
                synchronized (C0001a.class) {
                    if (this.f4a == null) {
                        this.f4a = this.f5b != null ? this.f5b.build() : new OkHttpClient();
                        this.f5b = null;
                    }
                }
            }
            return new C0000a(str, this.f4a);
        }
    }
}
