package classesdef.browser;

import android.app.Application;
import android.util.Log;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;

@Singleton
/* renamed from: bqe */
public class bqe {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Set<String> f16414a = new HashSet();

    /* renamed from: b */
    private final bpn f16415b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Application f16416c;

    /* renamed from: d */
    private boolean f16417d;

    @Inject
    public bqe(Application application, bpn bpn) {
        this.f16416c = application;
        this.f16415b = bpn;
        if (this.f16414a.isEmpty()) {
            m18931b().mo21839a(C4740s.m21407e()).mo23839a();
        }
        this.f16417d = this.f16415b.mo23459c();
    }

    /* renamed from: a */
    public void mo23562a() {
        this.f16417d = this.f16415b.mo23459c();
    }

    /* renamed from: a */
    public boolean mo23563a(String str) {
        if (!this.f16417d || str == null) {
            return false;
        }
        try {
            boolean contains = this.f16414a.contains(m18932b(str));
            if (contains) {
                Log.d("AdBlock", "URL '" + str + "' is an ad");
            }
            return contains;
        } catch (URISyntaxException e) {
            Log.d("AdBlock", "URL '" + str + "' is invalid", e);
            return false;
        }
    }

    /* renamed from: b */
    private static String m18932b(String str) throws URISyntaxException {
        int indexOf = str.indexOf(47, 8);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        String host = new URI(str).getHost();
        if (host == null) {
            return str;
        }
        return host.startsWith("www.") ? host.substring(4) : host;
    }

    /* renamed from: b */
    private C3659b m18931b() {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(bqe.this.f16416c.getAssets().open("hosts.txt")));
                    try {
                        StringBuilder sb = new StringBuilder();
                        long currentTimeMillis = System.currentTimeMillis();
                        while (true) {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                                if (!bqr.m18982b(sb) && !bqr.m18981a(sb, "#")) {
                                    bqr.m18980a(sb, "127.0.0.1", "");
                                    bqr.m18980a(sb, "0.0.0.0", "");
                                    bqr.m18980a(sb, "::1", "");
                                    bqr.m18980a(sb, "\t", "");
                                    int indexOf = sb.indexOf("#");
                                    if (indexOf >= 0) {
                                        sb.replace(indexOf, sb.length(), "");
                                    }
                                    bqr.m18979a(sb);
                                    if (!bqr.m18982b(sb) && !bqr.m18984c(sb, "localhost")) {
                                        while (bqr.m18983b(sb, " ")) {
                                            StringBuilder a = bqr.m18978a(sb, 0, sb.indexOf(" "));
                                            bqr.m18979a(a);
                                            String sb2 = a.toString();
                                            bqe.this.f16414a.add(sb2);
                                            bqr.m18980a(sb, sb2, "");
                                            bqr.m18979a(sb);
                                        }
                                        if (sb.length() > 0) {
                                            bqe.this.f16414a.add(sb.toString());
                                        }
                                    }
                                }
                                sb.setLength(0);
                            } else {
                                Log.d("AdBlock", "Loaded ad list in: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                bqw.m19016a((Closeable) bufferedReader2);
                                return;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        try {
                            Log.wtf("AdBlock", "Reading blocked domains list from file 'hosts.txt' failed.", e);
                            bqw.m19016a((Closeable) bufferedReader);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            bqw.m19016a((Closeable) bufferedReader2);
                        //    throw th;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bqw.m19016a((Closeable) bufferedReader2);
                        //throw th;
                    }
                } catch (IOException e) {
                    //e = e2;
                    Log.wtf("AdBlock", "Reading blocked domains list from file 'hosts.txt' failed.", e);
                    bqw.m19016a((Closeable) bufferedReader);
                }
            }
        });
    }
}
