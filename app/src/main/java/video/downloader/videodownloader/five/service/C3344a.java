package video.downloader.videodownloader.five.service;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.MimeTypeMap;
import com.mopub.common.Constants;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.mobileads.VastIconXmlManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import classesdef.browser.bon;
import classesdef.browser.BrowserData;
import classesdef.browser.bph;
import classesdef.browser.bqq;
import classesdef.browser.download.boi;
import classesdef.browser.download.bpd;
import classesdef.browser.download.bpf;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: video.downloader.videodownloader.five.service.a */
public class C3344a {

    /* renamed from: a */
    private static String f11681a;

    /* renamed from: a */
    public static String m14430a(Context context, Document document, String str) {
        Log.e("typeDownlod","one15");
        try {
            Elements elementsByAttributeValue = document.getElementsByAttributeValue("property", str);
            if (elementsByAttributeValue.size() <= 0) {
                return "";
            }
            Element element = (Element) elementsByAttributeValue.get(0);
            if (element.hasAttr("content")) {
                return element.attr("content");
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static int m14428a(Context context, String str) {
        Log.e("typeDownlod","one14");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str) * 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: b */
    private static int m14437b(Context context, String str) {
        Log.e("typeDownlod","one13");
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String[] split = str.split(":");
            if (split.length == 2) {
                i = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
            } else if (split.length == 3) {
                i = (Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]);
            }
            return i * 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public static ArrayList<bph> m14432a(Context context, String str, String str2, String str3) {
        Log.e("typeDownlod","one12");
        String str4;
        int i;
        ArrayList<bph> arrayList = new ArrayList<>();
        String str5 = "";
        try {
            Document parse = Jsoup.parse(str3);
            int a = m14428a(context, m14430a(context, parse, "video:duration"));
            String a2 = m14430a(context, parse, "og:image");
            str5 = m14430a(context, parse, "og:title");
            str4 = a2;
            i = a;
        } catch (Exception e) {
            e.printStackTrace();
            str4 = "";
            i = 0;
        }
        if (!TextUtils.isEmpty(str5)) {
            str = str5;
        }
        Matcher matcher = Pattern.compile("mediaDefinition\\s*:(.*?)],").matcher(str3);
        if (matcher.find()) {
            arrayList = m14433a(context, matcher.group(1) + "]", str2, str, i, str4);
        }
        if (arrayList.isEmpty()) {
            Matcher matcher2 = Pattern.compile("page_params.video.mediaDefinition = (.*?);").matcher(str3);
            if (matcher2.find()) {
                arrayList = m14433a(context, matcher2.group(1), str2, str, i, str4);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        String a3 = m14430a(context, Jsoup.parse(str3), "og:video:url");
        return (TextUtils.isEmpty(a3) || !a3.contains(BrowserData.m18398i(context).substring(10))) ? arrayList : m14440b(context, str, str2, a3, i, str4);
    }

    /* renamed from: a */
    private static ArrayList<bph> m14433a(Context context, String str, String str2, String str3, int i, String str4) {
        Log.e("typeDownlod","one11");
        ArrayList<bph> arrayList = new ArrayList<>();
        try {
            String str5 = str;
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String optString = jSONObject.optString("videoUrl");
                String optString2 = jSONObject.optString("format");
                if (TextUtils.isEmpty(optString2) || !optString2.equals("hls")) {
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(bpd.m21193a(context, optString, str2, str3, i, m14438b(jSONObject.optString("quality", "240")), str4));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: b */
    private static ArrayList<bph> m14440b(Context context, String str, String str2, String str3, int i, String str4) {
        Log.e("typeDownlod","one10");
        ArrayList<bph> arrayList = new ArrayList<>();
        try {
            OkHttpClient.Builder aVar = new OkHttpClient.Builder();
            aVar.connectTimeout(10000, TimeUnit.MILLISECONDS);
            aVar.readTimeout(10000, TimeUnit.MILLISECONDS);
            aVar.retryOnConnectionFailure(true);
            Response a = aVar.build().newCall(new Request.Builder().url(str3).addHeader("Cookie", CookieManager.getInstance().getCookie(str2)).build()).execute();
            if (!a.isSuccessful()) {
                return arrayList;
            }
            String e = a.body().string();
            Matcher matcher = Pattern.compile("poster\\s*:\\s*'(.*?)'\\s*,").matcher(e);
            String group = matcher.find() ? matcher.group(1) : str4;
            Matcher matcher2 = Pattern.compile("mediaDefinition\\s*:(.*?)],").matcher(e);
            if (!matcher2.find()) {
                return arrayList;
            }
            return m14433a(context, matcher2.group(1) + "]", str2, str, i, group);
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0124  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<bph> m14439b_(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r8 = r17
            r9 = r20
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.String r1 = ""
            java.lang.String r2 = ""
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.parse(r20)     // Catch:{ Exception -> 0x001f }
            java.lang.String r3 = "og:image"
            java.lang.String r1 = m14430a(r8, r0, r3)     // Catch:{ Exception -> 0x001f }
            java.lang.String r3 = "og:title"
            java.lang.String r0 = m14430a(r8, r0, r3)     // Catch:{ Exception -> 0x001f }
            r11 = r1
            goto L_0x0025
        L_0x001f:
            r0 = move-exception
            r0.printStackTrace()
            r11 = r1
            r0 = r2
        L_0x0025:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x002d
            r12 = r0
            goto L_0x002f
        L_0x002d:
            r12 = r18
        L_0x002f:
            java.lang.String r0 = "\"duration\":(.*?),"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r9)
            boolean r1 = r0.find()
            r13 = 0
            r14 = 1
            if (r1 == 0) goto L_0x0052
            java.lang.String r0 = r0.group(r14)
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x004d }
            int r0 = r0 * 1000
            r15 = r0
            goto L_0x0053
        L_0x004d:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x0052:
            r15 = 0
        L_0x0053:
            java.lang.String r0 = "\"mp4\":(.*?),\"userSettings\":"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r9)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x00c4
            java.lang.String r0 = r0.group(r14)
            java.lang.String r1 = "}"
            boolean r1 = r0.endsWith(r1)     // Catch:{ JSONException -> 0x00c0 }
            if (r1 == 0) goto L_0x0078
            int r1 = r0.length()     // Catch:{ JSONException -> 0x00c0 }
            int r1 = r1 - r14
            java.lang.String r0 = r0.substring(r13, r1)     // Catch:{ JSONException -> 0x00c0 }
        L_0x0078:
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00c0 }
            r7.<init>(r0)     // Catch:{ JSONException -> 0x00c0 }
            r0 = 0
        L_0x007e:
            int r1 = r7.length()     // Catch:{ JSONException -> 0x00c0 }
            if (r0 >= r1) goto L_0x00c4
            org.json.JSONObject r1 = r7.getJSONObject(r0)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r2 = "url"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ JSONException -> 0x00c0 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00c0 }
            if (r3 != 0) goto L_0x00b9
            java.lang.String r3 = ".m3u8?"
            boolean r3 = r2.contains(r3)     // Catch:{ JSONException -> 0x00c0 }
            if (r3 != 0) goto L_0x00b9
            java.lang.String r3 = "quality"
            java.lang.String r4 = "240p"
            java.lang.String r1 = r1.optString(r3, r4)     // Catch:{ JSONException -> 0x00c0 }
            int r6 = m14438b(r1)     // Catch:{ JSONException -> 0x00c0 }
            r1 = r17
            r3 = r19
            r4 = r12
            r5 = r15
            r16 = r7
            r7 = r11
            bph r1 = p000.bpd.m21193a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x00c0 }
            r10.add(r1)     // Catch:{ JSONException -> 0x00c0 }
            goto L_0x00bb
        L_0x00b9:
            r16 = r7
        L_0x00bb:
            int r0 = r0 + 1
            r7 = r16
            goto L_0x007e
        L_0x00c0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00c4:
            boolean r0 = r10.isEmpty()
            r7 = 32
            if (r0 == 0) goto L_0x011e
            java.lang.String r0 = "window.initials\\s*=\\s*(.*?)</script>"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0, r7)
            java.util.regex.Matcher r0 = r0.matcher(r9)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x011e
            java.lang.String r0 = r0.group(r14)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x011a }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r0 = "xplayerSettings"
            org.json.JSONObject r0 = r1.getJSONObject(r0)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r1 = "sources"
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r1 = "standard"
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r1 = "mp4"
            org.json.JSONArray r0 = r0.getJSONArray(r1)     // Catch:{ JSONException -> 0x011a }
        L_0x00fd:
            int r1 = r0.length()     // Catch:{ JSONException -> 0x011a }
            if (r13 >= r1) goto L_0x011e
            org.json.JSONObject r2 = r0.getJSONObject(r13)     // Catch:{ JSONException -> 0x011a }
            r1 = r17
            r3 = r19
            r4 = r12
            r5 = r15
            r6 = r11
            bph r1 = m14429a((android.content.Context) r1, (org.json.JSONObject) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5, (java.lang.String) r6)     // Catch:{ JSONException -> 0x011a }
            if (r1 == 0) goto L_0x0117
            r10.add(r1)     // Catch:{ JSONException -> 0x011a }
        L_0x0117:
            int r13 = r13 + 1
            goto L_0x00fd
        L_0x011a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x011e:
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x01ab
            java.lang.String r0 = "window.initials = (.*?)</script>"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0, r7)
            java.util.regex.Matcher r0 = r0.matcher(r9)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x01ab
            java.lang.String r0 = r0.group(r14)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01a7 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x01a7 }
            java.lang.String r0 = "vr"
            org.json.JSONObject r0 = r1.getJSONObject(r0)     // Catch:{ JSONException -> 0x01a7 }
            java.lang.String r1 = "sources"
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ JSONException -> 0x01a7 }
            java.util.Iterator r9 = r0.keys()     // Catch:{ JSONException -> 0x01a7 }
        L_0x014d:
            boolean r1 = r9.hasNext()     // Catch:{ JSONException -> 0x01a7 }
            if (r1 == 0) goto L_0x01ab
            java.lang.Object r1 = r9.next()     // Catch:{ JSONException -> 0x01a7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x01a7 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01a7 }
            if (r2 != 0) goto L_0x014d
            java.lang.Object r2 = r0.get(r1)     // Catch:{ JSONException -> 0x01a7 }
            boolean r2 = r2 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x01a7 }
            if (r2 == 0) goto L_0x014d
            int r2 = m14438b(r1)     // Catch:{ JSONException -> 0x01a7 }
            java.lang.String r3 = "psvr"
            boolean r3 = r1.equals(r3)     // Catch:{ JSONException -> 0x01a7 }
            if (r3 == 0) goto L_0x0178
            r2 = 2160(0x870, float:3.027E-42)
            r6 = 2160(0x870, float:3.027E-42)
            goto L_0x0179
        L_0x0178:
            r6 = r2
        L_0x0179:
            java.lang.Object r1 = r0.get(r1)     // Catch:{ JSONException -> 0x01a7 }
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x01a7 }
            java.lang.String r2 = "downloadUrl"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ JSONException -> 0x01a7 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01a7 }
            if (r3 == 0) goto L_0x0192
            java.lang.String r2 = "url"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ JSONException -> 0x01a7 }
            r2 = r1
        L_0x0192:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01a7 }
            if (r1 != 0) goto L_0x014d
            r1 = r17
            r3 = r19
            r4 = r12
            r5 = r15
            r7 = r11
            bph r1 = p000.bpd.m21193a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x01a7 }
            r10.add(r1)     // Catch:{ JSONException -> 0x01a7 }
            goto L_0x014d
        L_0x01a7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01ab:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.videodownloader.five.service.C3344a.m14439b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.util.ArrayList");
    }
    public static ArrayList<bph> m14439b(Context context, String str, String str2, String str3) {
        Log.e("typeDownlod","one9");
        String str4;
        String str5;
        int i = 0;
        Matcher matcher;
        JSONArray jSONArray;
        ArrayList<bph> arrayList = new ArrayList<>();
        String str6 = "";
        try {
            Document parse = Jsoup.parse(str3);
            str6 = m14430a(context, parse, "og:image");
            str5 = m14430a(context, parse, "og:title");
            str4 = str6;
        } catch (Exception e) {
            e.printStackTrace();
            str4 = str6;
            str5 = "";
        }
        String str7 = !TextUtils.isEmpty(str5) ? str5 : str;
        Matcher matcher2 = Pattern.compile("\"duration\":(.*?),").matcher(str3);
        if (matcher2.find()) {
            try {
                i = Integer.parseInt(matcher2.group(1)) * 1000;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            matcher = Pattern.compile("\"mp4\":(.*?),\"userSettings\":").matcher(str3);
            if (matcher.find()) {
                String group = matcher.group(1);
                try {
                    if (group.endsWith("}")) {
                        group = group.substring(0, group.length() - 1);
                    }
                    JSONArray jSONArray2 = new JSONArray(group);
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                        String optString = jSONObject.optString("url");
                        if (TextUtils.isEmpty(optString) || optString.contains(".m3u8?")) {
                            jSONArray = jSONArray2;
                        } else {
                            jSONArray = jSONArray2;
                            arrayList.add(bpd.m21193a(context, optString, str2, str7, i, m14438b(jSONObject.optString("quality", "240p")), str4));
                        }
                        i2++;
                        jSONArray2 = jSONArray;
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (arrayList.isEmpty()) {
                Matcher matcher3 = Pattern.compile("window.initials\\s*=\\s*(.*?)</script>", 32).matcher(str3);
                if (matcher3.find()) {
                    try {
                        JSONArray jSONArray3 = new JSONObject(matcher3.group(1)).getJSONObject("xplayerSettings").getJSONObject("sources").getJSONObject("standard").getJSONArray("mp4");
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            bph a2 = m14429a(context, jSONArray3.getJSONObject(i3), str2, str7, i, str4);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            if (arrayList.isEmpty()) {
                Matcher matcher4 = Pattern.compile("window.initials = (.*?)</script>", 32).matcher(str3);
                if (matcher4.find()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(matcher4.group(1)).getJSONObject("vr").getJSONObject("sources");
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next) && (jSONObject2.get(next) instanceof JSONObject)) {
                                int b = next.equals("psvr") ? 2160 : m14438b(next);
                                JSONObject jSONObject3 = (JSONObject) jSONObject2.get(next);
                                String optString2 = jSONObject3.optString("downloadUrl");
                                if (TextUtils.isEmpty(optString2)) {
                                    optString2 = jSONObject3.optString("url");
                                }
                                if (!TextUtils.isEmpty(optString2)) {
                                    arrayList.add(bpd.m21193a(context, optString2, str2, str7, i, b, str4));
                                }
                            }
                        }
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                }
            }
            return arrayList;
        }
        i = 0;
        matcher = Pattern.compile("\"mp4\":(.*?),\"userSettings\":").matcher(str3);
        if (matcher.find()) {
        }
        if (arrayList.isEmpty()) {
        }
        if (arrayList.isEmpty()) {
        }
        return arrayList;
    }

    /* renamed from: a */
    private static bph m14429a(Context context, JSONObject jSONObject, String str, String str2, int i, String str3) {
        Log.e("typeDownlod","one8");
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("fallback");
        String str4 = (!TextUtils.isEmpty(optString) ? !optString.toLowerCase().contains("?") || TextUtils.isEmpty(optString2) || optString2.toLowerCase().contains("?") : TextUtils.isEmpty(optString2)) ? optString : optString2;
        if (TextUtils.isEmpty(str4) || str4.contains(".m3u8?")) {
            return null;
        }
        return bpd.m21193a(context, str4, str, str2, i, jSONObject.optString("quality", "240p").equals("psvr") ? 2160 : m14438b(jSONObject.optString("quality", "240p")), str3);
    }

    /* renamed from: c */
    public static ArrayList<bph> m14442c(Context context, String str, String str2, String str3) {
        Log.e("typeDownlod","one7");
        String str4;
        int i;
        String str5;
        Context context2 = context;
        String str6 = str3;
        ArrayList<bph> arrayList = new ArrayList<>();
        try {
            Document parse = Jsoup.parse(str3);
            int a = m14428a(context, m14430a(context, parse, "og:duration"));
            String a2 = m14430a(context, parse, "og:image");
            str5 = m14430a(context, parse, "og:title");
            str4 = a2;
            i = a;
        } catch (Exception e) {
            e.printStackTrace();
            str4 = "";
            str5 = "";
            i = 0;
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = str;
        }
        Matcher matcher = Pattern.compile("setVideoUrlHigh(.*?);").matcher(str6);
        if (matcher.find()) {
            String group = matcher.group(1);
            if (!TextUtils.isEmpty(group)) {
                arrayList.add(bpd.m21193a(context, group.substring(2, group.length() - 2), str2, str5, i, 720, str4));
            }
        }
        Matcher matcher2 = Pattern.compile("setVideoUrlLow(.*?);").matcher(str6);
        if (matcher2.find()) {
            String group2 = matcher2.group(1);
            if (!TextUtils.isEmpty(group2)) {
                arrayList.add(bpd.m21193a(context, group2.substring(2, group2.length() - 2), str2, str5, i, 360, str4));
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static List<bph> m14444d(Context context, String str, String str2, String str3) {
        Log.e("typeDownlod","one6");
        ArrayList arrayList = new ArrayList();
        String str4 = "";
        try {
            String a = m14430a(context, Jsoup.parse(str3), "og:title");
            if (!TextUtils.isEmpty(a)) {
                str = a;
            }
            Matcher matcher = Pattern.compile("posterImage: '(.*?)',").matcher(str3);
            if (matcher.find()) {
                str4 = m14431a(matcher.group(1));
            }
            Matcher matcher2 = Pattern.compile("var\\s.{0,20}ncodings = (.*?);").matcher(str3);
            if (matcher2.find()) {
                JSONArray jSONArray = new JSONArray(matcher2.group(1));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    int b = m14438b(jSONObject.optString("quality"));
                    String a2 = m14431a(jSONObject.optString("filename"));
                    if (!a2.contains(".m3u8") && !TextUtils.isEmpty(a2)) {
                        arrayList.add(bpd.m21193a(context, a2, str2, str, 0, b, str4));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0052 A[Catch:{ Exception -> 0x0188 }] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<bph> m14445e__(android.content.Context r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.parse(r15)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r2 = "og:title"
            java.lang.String r2 = m14430a(r12, r1, r2)     // Catch:{ Exception -> 0x0188 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0188 }
            if (r3 != 0) goto L_0x0016
            r13 = r2
        L_0x0016:
            java.lang.String r2 = "og:image"
            java.lang.String r1 = m14430a(r12, r1, r2)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r1 = m14431a((java.lang.String) r1)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r2 = "class=\"i-length\">(.*?)</span>"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ Exception -> 0x0188 }
            java.util.regex.Matcher r2 = r2.matcher(r15)     // Catch:{ Exception -> 0x0188 }
            boolean r3 = r2.find()     // Catch:{ Exception -> 0x0188 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0041
            java.lang.String r2 = r2.group(r5)     // Catch:{ Exception -> 0x0188 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0188 }
            if (r3 != 0) goto L_0x0041
            int r2 = m14437b(r12, r2)     // Catch:{ Exception -> 0x0188 }
            goto L_0x0042
        L_0x0041:
            r2 = 0
        L_0x0042:
            java.lang.String r3 = "data-streamkey=\"(.*?)\">"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch:{ Exception -> 0x0188 }
            java.util.regex.Matcher r15 = r3.matcher(r15)     // Catch:{ Exception -> 0x0188 }
            boolean r3 = r15.find()     // Catch:{ Exception -> 0x0188 }
            if (r3 == 0) goto L_0x018c
            java.lang.String r15 = r15.group(r5)     // Catch:{ Exception -> 0x0188 }
            boolean r3 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0188 }
            if (r3 != 0) goto L_0x018c
            java.lang.String r3 = ""
            android.webkit.CookieManager r6 = android.webkit.CookieManager.getInstance()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = r6.getCookie(r14)     // Catch:{ Exception -> 0x0188 }
            if (r6 == 0) goto L_0x0090
            boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x0188 }
            if (r7 != 0) goto L_0x0090
            java.lang.String r7 = ";"
            java.lang.String[] r6 = r6.split(r7)     // Catch:{ Exception -> 0x0188 }
            r7 = 0
        L_0x0075:
            int r8 = r6.length     // Catch:{ Exception -> 0x0188 }
            if (r7 >= r8) goto L_0x0090
            r8 = r6[r7]     // Catch:{ Exception -> 0x0188 }
            java.lang.String r9 = "sb_csrf_session="
            boolean r8 = r8.contains(r9)     // Catch:{ Exception -> 0x0188 }
            if (r8 == 0) goto L_0x008d
            r3 = r6[r7]     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = "="
            java.lang.String[] r3 = r3.split(r6)     // Catch:{ Exception -> 0x0188 }
            r3 = r3[r5]     // Catch:{ Exception -> 0x0188 }
            goto L_0x0090
        L_0x008d:
            int r7 = r7 + 1
            goto L_0x0075
        L_0x0090:
            ayj$a r5 = new ayj$a     // Catch:{ Exception -> 0x0188 }
            r5.<init>()     // Catch:{ Exception -> 0x0188 }
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0188 }
            r7 = 10000(0x2710, double:4.9407E-320)
            r5.connectTimeout(r7, r6)     // Catch:{ Exception -> 0x0188 }
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0188 }
            r5.readTimeout(r7, r6)     // Catch:{ Exception -> 0x0188 }
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0188 }
            r5.mo23771c(r7, r6)     // Catch:{ Exception -> 0x0188 }
            ayj r5 = r5.build()     // Catch:{ Exception -> 0x0188 }
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0188 }
            if (r6 != 0) goto L_0x00ce
            ayd$a r6 = new ayd$a     // Catch:{ Exception -> 0x0188 }
            r6.<init>()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r7 = "id"
            ayd$a r15 = r6.mo23660a(r7, r15)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = "data"
            java.lang.String r7 = "0"
            ayd$a r15 = r15.mo23660a(r6, r7)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = "sb_csrf_session"
            ayd$a r15 = r15.mo23660a(r6, r3)     // Catch:{ Exception -> 0x0188 }
            ayd r15 = r15.mo23661a()     // Catch:{ Exception -> 0x0188 }
            goto L_0x00e5
        L_0x00ce:
            ayd$a r6 = new ayd$a     // Catch:{ Exception -> 0x0188 }
            r6.<init>()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r7 = "id"
            ayd$a r15 = r6.mo23660a(r7, r15)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = "data"
            java.lang.String r7 = "0"
            ayd$a r15 = r15.mo23660a(r6, r7)     // Catch:{ Exception -> 0x0188 }
            ayd r15 = r15.mo23661a()     // Catch:{ Exception -> 0x0188 }
        L_0x00e5:
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0188 }
            if (r6 != 0) goto L_0x010b
            aym$a r6 = new aym$a     // Catch:{ Exception -> 0x0188 }
            r6.<init>()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r7 = "https://spankbang.com/api/videos/stream"
            aym$a r6 = r6.url((java.lang.String) r7)     // Catch:{ Exception -> 0x0188 }
            aym$a r15 = r6.mo23800a((p000.ayn) r15)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = "Referer"
            aym$a r15 = r15.addHeader(r6, r14)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = "X-CSRFToken"
            aym$a r15 = r15.addHeader(r6, r3)     // Catch:{ Exception -> 0x0188 }
            aym r15 = r15.build()     // Catch:{ Exception -> 0x0188 }
            goto L_0x0124
        L_0x010b:
            aym$a r3 = new aym$a     // Catch:{ Exception -> 0x0188 }
            r3.<init>()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = "https://spankbang.com/api/videos/stream"
            aym$a r3 = r3.url((java.lang.String) r6)     // Catch:{ Exception -> 0x0188 }
            aym$a r15 = r3.mo23800a((p000.ayn) r15)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r3 = "Referer"
            aym$a r15 = r15.addHeader(r3, r14)     // Catch:{ Exception -> 0x0188 }
            aym r15 = r15.build()     // Catch:{ Exception -> 0x0188 }
        L_0x0124:
            axr r15 = r5.newCall((p000.aym) r15)     // Catch:{ Exception -> 0x0188 }
            Response r15 = r15.execute()     // Catch:{ Exception -> 0x0188 }
            boolean r3 = r15.isSuccessful()     // Catch:{ Exception -> 0x0188 }
            if (r3 == 0) goto L_0x018c
            ayp r15 = r15.body()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r15 = r15.string()     // Catch:{ Exception -> 0x0188 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0188 }
            r3.<init>(r15)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r15 = "[{\"res\":1080,\"name\":\"1080p\"},{\"res\":240,\"name\":\"240p\"},{\"res\":320,\"name\":\"320p\"},{\"res\":480,\"name\":\"480p\"},{\"res\":1440,\"name\":\"4k\"},{\"res\":720,\"name\":\"720p\"}]"
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x0188 }
            r11.<init>(r15)     // Catch:{ Exception -> 0x0188 }
            r15 = 0
        L_0x0147:
            int r4 = r11.length()     // Catch:{ Exception -> 0x0188 }
            if (r15 >= r4) goto L_0x018c
            org.json.JSONObject r4 = r11.getJSONObject(r15)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r5 = "name"
            java.lang.String r4 = r4.optString(r5)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r5 = m14441c(r4)     // Catch:{ Exception -> 0x0188 }
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0188 }
            if (r4 != 0) goto L_0x0185
            java.lang.String r4 = "http"
            boolean r4 = r5.startsWith(r4)     // Catch:{ Exception -> 0x0188 }
            if (r4 == 0) goto L_0x0185
            org.json.JSONObject r4 = r11.getJSONObject(r15)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = "res"
            r7 = 240(0xf0, float:3.36E-43)
            int r9 = r4.optInt(r6, r7)     // Catch:{ Exception -> 0x0188 }
            r4 = r12
            r6 = r14
            r7 = r13
            r8 = r2
            r10 = r1
            bph r4 = p000.bpd.m21193a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0188 }
            r0.add(r4)     // Catch:{ Exception -> 0x0188 }
        L_0x0185:
            int r15 = r15 + 1
            goto L_0x0147
        L_0x0188:
            r12 = move-exception
            r12.printStackTrace()
        L_0x018c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.videodownloader.five.service.C3344a.m14445e(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.util.ArrayList");
    }
    public static ArrayList<bph> m14445e(Context context, String str, String str2, String str3) {
        Log.e("typeDownlod","one5");
        int i;
        Matcher matcher;
        FormBody ayd;
        Request aym;
        ArrayList<bph> arrayList = new ArrayList<>();
        try {
            Document parse = Jsoup.parse(str3);
            String a2 = m14430a(context, parse, "og:title");
            if (!TextUtils.isEmpty(a2)) {
                str = a2;
            }
            String a3 = m14431a(m14430a(context, parse, "og:image"));
            Matcher matcher2 = Pattern.compile("class=\"i-length\">(.*?)</span>").matcher(str3);
            if (matcher2.find()) {
                String group = matcher2.group(1);
                if (!TextUtils.isEmpty(group)) {
                    i = m14437b(context, group);
                    matcher = Pattern.compile("data-streamkey=\"(.*?)\">").matcher(str3);
                    if (matcher.find()) {
                        String group2 = matcher.group(1);
                        if (!TextUtils.isEmpty(group2)) {
                            String str4 = "";
                            String cookie = CookieManager.getInstance().getCookie(str2);
                            if (cookie != null && !cookie.isEmpty()) {
                                String[] split = cookie.split(";");
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= split.length) {
                                        break;
                                    } else if (split[i2].contains("sb_csrf_session=")) {
                                        str4 = split[i2].split("=")[1];
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                            OkHttpClient.Builder aVar = new OkHttpClient.Builder();
                            aVar.connectTimeout(10000, TimeUnit.MILLISECONDS);
                            aVar.readTimeout(10000, TimeUnit.MILLISECONDS);
                            aVar.writeTimeout(10000, TimeUnit.MILLISECONDS);
                            OkHttpClient a4 = aVar.build();
                            if (!TextUtils.isEmpty(str4)) {
                                ayd = new FormBody.Builder().add("id", group2).add("data", "0").add("sb_csrf_session", str4).build();
                            } else {
                                ayd = new FormBody.Builder().add("id", group2).add("data", "0").build();
                            }
                            if (!TextUtils.isEmpty(str4)) {
                                aym = new Request.Builder().url("https://spankbang.com/api/videos/stream").post(ayd).addHeader("Referer", str2).addHeader("X-CSRFToken", str4).build();
                            } else {
                                aym = new Request.Builder().url("https://spankbang.com/api/videos/stream").post(ayd).addHeader("Referer", str2).build();
                            }
                            Response a5 = a4.newCall(aym).execute();
                            if (a5.isSuccessful()) {
                                JSONObject jSONObject = new JSONObject(a5.body().string());
                                JSONArray jSONArray = new JSONArray("[{\"res\":1080,\"name\":\"1080p\"},{\"res\":240,\"name\":\"240p\"},{\"res\":320,\"name\":\"320p\"},{\"res\":480,\"name\":\"480p\"},{\"res\":1440,\"name\":\"4k\"},{\"res\":720,\"name\":\"720p\"}]");
                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                    String c = m14441c(jSONObject.getString(jSONArray.getJSONObject(i3).optString("name")));
                                    if (!TextUtils.isEmpty(c) && c.startsWith("http")) {
                                        arrayList.add(bpd.m21193a(context, c, str2, str, i, jSONArray.getJSONObject(i3).optInt("res", 240), a3));
                                    }
                                }
                            }
                        }
                    }
                    return arrayList;
                }
            }
            i = 0;
            matcher = Pattern.compile("data-streamkey=\"(.*?)\">").matcher(str3);
            if (matcher.find()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0112  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<bph> m14446f__(android.content.Context r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            r8 = r18
            r9 = r21
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.String r1 = ""
            java.lang.String r2 = ""
            java.lang.String r3 = ""
            r11 = 0
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.parse(r21)     // Catch:{ Exception -> 0x003b }
            java.lang.String r4 = "video:duration"
            java.lang.String r4 = m14430a(r8, r0, r4)     // Catch:{ Exception -> 0x003b }
            int r4 = m14428a((android.content.Context) r8, (java.lang.String) r4)     // Catch:{ Exception -> 0x003b }
            if (r4 != 0) goto L_0x002a
            java.lang.String r5 = "og:video:duration"
            java.lang.String r5 = m14430a(r8, r0, r5)     // Catch:{ Exception -> 0x0039 }
            int r4 = m14428a((android.content.Context) r8, (java.lang.String) r5)     // Catch:{ Exception -> 0x0039 }
        L_0x002a:
            java.lang.String r5 = "og:image"
            java.lang.String r1 = m14430a(r8, r0, r5)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r5 = "og:title"
            java.lang.String r0 = m14430a(r8, r0, r5)     // Catch:{ Exception -> 0x0039 }
            r12 = r1
            r13 = r4
            goto L_0x0043
        L_0x0039:
            r0 = move-exception
            goto L_0x003d
        L_0x003b:
            r0 = move-exception
            r4 = 0
        L_0x003d:
            r0.printStackTrace()
            r12 = r1
            r0 = r2
            r13 = r4
        L_0x0043:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x004b
            r14 = r0
            goto L_0x004d
        L_0x004b:
            r14 = r19
        L_0x004d:
            java.lang.String r0 = "\"mediaDefinitions\":(.*)],\""
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r9)
            boolean r1 = r0.find()
            r15 = 1
            if (r1 == 0) goto L_0x00f5
            java.lang.String r0 = r0.group(r15)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "]"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ed }
            r7.<init>(r0)     // Catch:{ JSONException -> 0x00ed }
            r16 = r3
            r0 = 0
        L_0x007b:
            int r1 = r7.length()     // Catch:{ JSONException -> 0x00eb }
            if (r0 >= r1) goto L_0x00e8
            org.json.JSONObject r1 = r7.getJSONObject(r0)     // Catch:{ JSONException -> 0x00eb }
            java.lang.String r2 = "format"
            java.lang.String r3 = ""
            java.lang.String r2 = r1.optString(r2, r3)     // Catch:{ JSONException -> 0x00eb }
            java.lang.String r3 = "dash"
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x00eb }
            if (r2 != 0) goto L_0x00e1
            java.lang.String r2 = "format"
            java.lang.String r3 = ""
            java.lang.String r2 = r1.optString(r2, r3)     // Catch:{ JSONException -> 0x00eb }
            java.lang.String r3 = "hls"
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x00eb }
            if (r2 == 0) goto L_0x00a8
            r17 = r7
            goto L_0x00e3
        L_0x00a8:
            java.lang.String r2 = "videoUrl"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ JSONException -> 0x00eb }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00eb }
            if (r3 != 0) goto L_0x00de
            java.lang.String r3 = "remote"
            boolean r3 = r1.optBoolean(r3)     // Catch:{ JSONException -> 0x00eb }
            if (r3 == 0) goto L_0x00c1
            r16 = r2
            r17 = r7
            goto L_0x00e3
        L_0x00c1:
            java.lang.String r3 = "quality"
            java.lang.String r4 = "240"
            java.lang.String r1 = r1.optString(r3, r4)     // Catch:{ JSONException -> 0x00eb }
            int r6 = m14438b(r1)     // Catch:{ JSONException -> 0x00eb }
            r1 = r18
            r3 = r20
            r4 = r14
            r5 = r13
            r17 = r7
            r7 = r12
            bph r1 = p000.bpd.m21193a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x00eb }
            r10.add(r1)     // Catch:{ JSONException -> 0x00eb }
            goto L_0x00e3
        L_0x00de:
            r17 = r7
            goto L_0x00e3
        L_0x00e1:
            r17 = r7
        L_0x00e3:
            int r0 = r0 + 1
            r7 = r17
            goto L_0x007b
        L_0x00e8:
            r3 = r16
            goto L_0x00f5
        L_0x00eb:
            r0 = move-exception
            goto L_0x00f0
        L_0x00ed:
            r0 = move-exception
            r16 = r3
        L_0x00f0:
            r0.printStackTrace()
            r3 = r16
        L_0x00f5:
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x010c
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x010c
            r1 = r18
            r2 = r20
            r4 = r14
            r5 = r13
            r6 = r12
            java.util.ArrayList r10 = m14443c(r1, r2, r3, r4, r5, r6)
        L_0x010c:
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x01b7
            java.lang.String r0 = "flashvars_(.*?)="
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r9)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x01b7
            java.lang.String r0 = r0.group(r15)
            java.lang.String r1 = " "
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "qualityItems_"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "\\s*=\\s*\"(.*?)]\";"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r9)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x01b7
            java.lang.String r0 = r0.group(r15)
            java.lang.String r1 = "\\"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "]"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ JSONException -> 0x01b3 }
            r9.<init>(r0)     // Catch:{ JSONException -> 0x01b3 }
        L_0x0180:
            int r0 = r9.length()     // Catch:{ JSONException -> 0x01b3 }
            if (r11 >= r0) goto L_0x01b7
            org.json.JSONObject r0 = r9.getJSONObject(r11)     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r1 = "url"
            java.lang.String r2 = r0.optString(r1)     // Catch:{ JSONException -> 0x01b3 }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01b3 }
            if (r1 != 0) goto L_0x01b0
            java.lang.String r1 = "text"
            java.lang.String r3 = "240"
            java.lang.String r0 = r0.optString(r1, r3)     // Catch:{ JSONException -> 0x01b3 }
            int r6 = m14438b(r0)     // Catch:{ JSONException -> 0x01b3 }
            r1 = r18
            r3 = r20
            r4 = r14
            r5 = r13
            r7 = r12
            bph r0 = p000.bpd.m21193a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x01b3 }
            r10.add(r0)     // Catch:{ JSONException -> 0x01b3 }
        L_0x01b0:
            int r11 = r11 + 1
            goto L_0x0180
        L_0x01b3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01b7:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.videodownloader.five.service.C3344a.m14446f(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.util.ArrayList");
    }
    public static ArrayList<bph> m14446f(Context context, String str, String str2, String str3) {
        Log.e("typeDownlod","one4");
        int i;
        String str4;
        String str5;
        String str6=null;
        Matcher matcher;
        String str7;
        JSONException e;
        JSONArray jSONArray;
        int i2;
        Exception e2;
        ArrayList<bph> arrayList = new ArrayList<>();
        String str8 = "";
        try {
            Document parse = Jsoup.parse(str3);
            i2 = m14428a(context, m14430a(context, parse, "video:duration"));
            if (i2 == 0) {
                try {
                    i2 = m14428a(context, m14430a(context, parse, "og:video:duration"));
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    str4 = "";
                    str5 = "";
                    i = i2;
                    if (!TextUtils.isEmpty(str5)) {
                    }
                    matcher = Pattern.compile("\"mediaDefinitions\":(.*)],\"").matcher(str3);
                    if (matcher.find()) {
                    }
                    arrayList = m14443c(context, str2, str8, str6, i, str4);
                    if (arrayList.isEmpty()) {
                    }
                    return arrayList;
                }
            }
            String a2 = m14430a(context, parse, "og:image");
            str5 = m14430a(context, parse, "og:title");
            str4 = a2;
            i = i2;
        } catch (Exception e4) {
            e2 = e4;
            i2 = 0;
            e2.printStackTrace();
            str4 = "";
            str5 = "";
            i = i2;
            if (!TextUtils.isEmpty(str5)) {
            }
            matcher = Pattern.compile("\"mediaDefinitions\":(.*)],\"").matcher(str3);
            if (matcher.find()) {
            }
            arrayList = m14443c(context, str2, str8, str6, i, str4);
            if (arrayList.isEmpty()) {
            }
            return arrayList;
        }
        str6 = !TextUtils.isEmpty(str5) ? str5 : str;
        matcher = Pattern.compile("\"mediaDefinitions\":(.*)],\"").matcher(str3);
        if (matcher.find()) {
            try {
                JSONArray jSONArray2 = new JSONArray(matcher.group(1) + "]");
                str7 = str8;
                int i3 = 0;
                while (i3 < jSONArray2.length()) {
                    try {
                        JSONObject jSONObject = jSONArray2.getJSONObject(i3);
                        if (jSONObject.optString("format", "").equals("dash")) {
                            jSONArray = jSONArray2;
                        } else if (jSONObject.optString("format", "").equals("hls")) {
                            jSONArray = jSONArray2;
                        } else {
                            String optString = jSONObject.optString("videoUrl");
                            if (TextUtils.isEmpty(optString)) {
                                jSONArray = jSONArray2;
                            } else if (jSONObject.optBoolean("remote")) {
                                str7 = optString;
                                jSONArray = jSONArray2;
                            } else {
                                jSONArray = jSONArray2;
                                arrayList.add(bpd.m21193a(context, optString, str2, str6, i, m14438b(jSONObject.optString("quality", "240")), str4));
                            }
                        }
                        i3++;
                        jSONArray2 = jSONArray;
                    } catch (JSONException e5) {
                        e = e5;
                        e.printStackTrace();
                        str8 = str7;
                        arrayList = m14443c(context, str2, str8, str6, i, str4);
                        if (arrayList.isEmpty()) {
                        }
                        return arrayList;
                    }
                }
                str8 = str7;
            } catch (JSONException e6) {
                e = e6;
                str7 = str8;
                e.printStackTrace();
                str8 = str7;
                arrayList = m14443c(context, str2, str8, str6, i, str4);
                if (arrayList.isEmpty()) {
                }
                return arrayList;
            }
        }
        if (arrayList.isEmpty() && !TextUtils.isEmpty(str8)) {
            arrayList = m14443c(context, str2, str8, str6, i, str4);
        }
        if (arrayList.isEmpty()) {
            Matcher matcher2 = Pattern.compile("flashvars_(.*?)=").matcher(str3);
            if (matcher2.find()) {
                Matcher matcher3 = Pattern.compile(("qualityItems_" + matcher2.group(1).replace(" ", "")) + "\\s*=\\s*\"(.*?)]\";").matcher(str3);
                if (matcher3.find()) {
                    try {
                        JSONArray jSONArray3 = new JSONArray(matcher3.group(1).replace("\\", "") + "]");
                        for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                            JSONObject jSONObject2 = jSONArray3.getJSONObject(i4);
                            String optString2 = jSONObject2.optString("url");
                            if (!TextUtils.isEmpty(optString2)) {
                                arrayList.add(bpd.m21193a(context, optString2, str2, str6, i, m14438b(jSONObject2.optString("text", "240")), str4));
                            }
                        }
                    } catch (JSONException e7) {
                        e7.printStackTrace();
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private static ArrayList<bph> m14443c(Context context, String str, String str2, String str3, int i, String str4) {
        Log.e("typeDownlod","one3");
        ArrayList<bph> arrayList = new ArrayList<>();
        try {
            OkHttpClient.Builder aVar = new OkHttpClient.Builder();
            aVar.connectTimeout(10000, TimeUnit.MILLISECONDS);
            aVar.readTimeout(10000, TimeUnit.MILLISECONDS);
            aVar.cookieJar( new bpf());
            aVar.retryOnConnectionFailure(true);
            String str5 = str2;
            Response a = aVar.build().newCall(new Request.Builder().url(str2).build()).execute();
            if (a.isSuccessful()) {
                try {
                    JSONArray jSONArray = new JSONArray(a.body().string());
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        String optString = jSONObject.optString("videoUrl");
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(bpd.m21193a(context, optString, str, str3, i, m14438b(jSONObject.optString("quality", "240")), str4));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: g */
    public static ArrayList<bph> m14447g(Context context, String str, String str2, String str3) {
        Log.e("typeDownlod","one2");
        String str4;
        ArrayList<bph> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int optInt = jSONObject.optInt(VastIconXmlManager.DURATION) * 1000;
            String optString = jSONObject.optString("poster_url");
            if (TextUtils.isEmpty(optString) && jSONObject.has("posters")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("posters");
                Iterator<String> keys = optJSONObject.keys();
                while (true) {
                    if (!keys.hasNext()) {
                        str4 = optString;
                        break;
                    }
                    optString = optJSONObject.optString(keys.next());
                    if (!TextUtils.isEmpty(optString)) {
                        str4 = optString;
                        break;
                    }
                }
            } else {
                str4 = optString;
            }
            String optString2 = jSONObject.optString("title");
            String str5 = TextUtils.isEmpty(optString2) ? str : optString2;
            boi.m18319b().mo23274c(str2);
            JSONObject jSONObject2 = jSONObject.getJSONObject("qualities");
            if (jSONObject2.has("144")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("144");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (jSONArray.getJSONObject(i).getString(VastExtensionXmlManager.TYPE).equals("video/mp4")) {
                        arrayList.add(bpd.m21193a(context, jSONArray.getJSONObject(i).getString("url"), str2, str, optInt, 160, str4));
                    }
                }
            }
            if (jSONObject2.has("240")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("240");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    if (jSONArray2.getJSONObject(i2).getString(VastExtensionXmlManager.TYPE).equals("video/mp4")) {
                        arrayList.add(bpd.m21193a(context, jSONArray2.getJSONObject(i2).getString("url"), str2, str, optInt, 240, str4));
                    }
                }
            }
            if (jSONObject2.has("380")) {
                JSONArray jSONArray3 = jSONObject2.getJSONArray("380");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    if (jSONArray3.getJSONObject(i3).getString(VastExtensionXmlManager.TYPE).equals("video/mp4")) {
                        arrayList.add(bpd.m21193a(context, jSONArray3.getJSONObject(i3).getString("url"), str2, str, optInt, 360, str4));
                    }
                }
            }
            if (jSONObject2.has("480")) {
                JSONArray jSONArray4 = jSONObject2.getJSONArray("480");
                for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                    if (jSONArray4.getJSONObject(i4).getString(VastExtensionXmlManager.TYPE).equals("video/mp4")) {
                        arrayList.add(bpd.m21193a(context, jSONArray4.getJSONObject(i4).getString("url"), str2, str, optInt, 480, str4));
                    }
                }
            }
            if (jSONObject2.has("720")) {
                JSONArray jSONArray5 = jSONObject2.getJSONArray("720");
                for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                    if (jSONArray5.getJSONObject(i5).getString(VastExtensionXmlManager.TYPE).equals("video/mp4")) {
                        arrayList.add(bpd.m21193a(context, jSONArray5.getJSONObject(i5).getString("url"), str2, str, optInt, 720, str4));
                    }
                }
            }
            if (jSONObject2.has("1080")) {
                JSONArray jSONArray6 = jSONObject2.getJSONArray("1080");
                for (int i6 = 0; i6 < jSONArray6.length(); i6++) {
                    if (jSONArray6.getJSONObject(i6).getString(VastExtensionXmlManager.TYPE).equals("video/mp4")) {
                        arrayList.add(bpd.m21193a(context, jSONArray6.getJSONObject(i6).getString("url"), str2, str, optInt, 1080, str4));
                    }
                }
            }
            if (arrayList.size() == 0 && jSONObject2.has("auto")) {
                JSONArray jSONArray7 = jSONObject2.getJSONArray("auto");
                int i7 = 0;
                while (true) {
                    if (i7 >= jSONArray7.length()) {
                        break;
                    } else if (jSONArray7.getJSONObject(i7).getString(VastExtensionXmlManager.TYPE).equals("application/x-mpegURL")) {
                        m14435a(context, jSONArray7.getJSONObject(i7).getString("url"), arrayList, str2, str5, optInt, str4);
                        break;
                    } else {
                        i7++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            m14434a(context, arrayList.get(i8));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m14435a(Context context, String str, List<bph> list, String str2, String str3, int i, String str4) {
        Log.e("typeDownlod","one1");
        boolean z;
        try {
            OkHttpClient.Builder aVar = new OkHttpClient.Builder();
            aVar.connectTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.readTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.retryOnConnectionFailure(true);
            String str5 = str;
            Response a = aVar.build().newCall(new Request.Builder().url(str).addHeader("Cookie", CookieManager.getInstance().getCookie(str2)).build()).execute();
            if (a.isSuccessful()) {
                for (String str6 : a.body().string().split("\n")) {
                    if (!str6.startsWith("#") || !str6.contains("PROGRESSIVE-URI")) {
                        List<bph> list2 = list;
                    } else {
                        String str7 = "";
                        int i2 = 0;
                        for (String str8 : str6.split(",")) {
                            if (str8.startsWith("RESOLUTION")) {
                                try {
                                    i2 = Integer.parseInt(str8.substring(str8.lastIndexOf("x") + 1, str8.length()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else if (str8.startsWith("PROGRESSIVE-URI")) {
                                str7 = str8.substring(17, str8.length() - 1);
                            }
                        }
                        Iterator<bph> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            bph next = it.next();
                            if (i2 != 0 && next.mo23359n() != 0 && i2 == next.mo23359n()) {
                                z = true;
                                break;
                            }
                        }
                        if (z || TextUtils.isEmpty(str7)) {
                            List<bph> list3 = list;
                        } else {
                            list.add(bpd.m21193a(context, str7, str2, str3, i, i2, str4));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m14434a(Context context, bph bph) {
        Log.e("typeDownlod","one15_");
        try {
            if (ManualParseService.m15259j(context, bph.mo23354i())) {
                String cookie = CookieManager.getInstance().getCookie(bph.mo23354i());
                if (!TextUtils.isEmpty(cookie) && cookie.contains("dmvk=")) {
                    bph.mo23351g(cookie);
                } else if (!TextUtils.isEmpty(f11681a)) {
                    bph.mo23351g(f11681a);
                } else {
                    m14436a(bph);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m14436a(bph bph) {
        Log.e("typeDownlod","one14");
        try {
            OkHttpClient.Builder aVar = new OkHttpClient.Builder();
            aVar.connectTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.readTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.writeTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.retryOnConnectionFailure(true);
            Response a = aVar.followRedirects(false).followSslRedirects(false).build().newCall(new Request.Builder().url(bph.mo23339c()).build()).execute();
            if (a.isRedirect()) {
                StringBuilder sb = new StringBuilder();
                List<String> a2 = a.headers("Set-Cookie");
                for (int i = 0; i < a2.size(); i++) {
                    sb.append(a2.get(i));
                    if (i < a2.size() - 1) {
                        sb.append("; ");
                    }
                }
                f11681a = sb.toString();
                bph.mo23351g(f11681a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: h */
    public static ArrayList<bph> m14448h(Context context, String str, String str2, String str3) {
        Log.e("typeDownlod","one13");
        ArrayList<bph> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str3);
            String str4 = bpd.m21196a(str2) + jSONObject.getJSONObject("playlist").getString("nq");
            int i = 0;
            while (i < 5) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str4.replace(" ", "%20")).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setConnectTimeout(6000);
                    httpURLConnection.setReadTimeout(6000);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode <= 300 || responseCode >= 400) {
                        break;
                    }
                    i++;
                    str4 = httpURLConnection.getHeaderField("Location");
                } catch (Exception e) {
                    e.printStackTrace();
                    i++;
                }
            }
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str4);
            if (!TextUtils.isEmpty(fileExtensionFromUrl) && bon.m18359a().mo23287b(fileExtensionFromUrl)) {
                arrayList.add(bpd.m21193a(context, str4, str2, str, 480, 0, ""));
                if (jSONObject.getJSONObject("playlist").has("hq")) {
                    arrayList.add(bpd.m21193a(context, bpd.m21196a(str2) + jSONObject.getJSONObject("playlist").getString("hq"), str2, str, 720, 0, ""));
                }
                if (jSONObject.getJSONObject("playlist").has("lq")) {
                    arrayList.add(bpd.m21193a(context, bpd.m21196a(str2) + jSONObject.getJSONObject("playlist").getString("lq"), str2, str, 360, 0, ""));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String cookie = CookieManager.getInstance().getCookie(str2);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).mo23353h(bqq.m21734i(context));
            if (!TextUtils.isEmpty(cookie)) {
                arrayList.get(i2).mo23351g(cookie);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m14431a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("http")) {
            return str;
        }
        return "http:" + str;
    }

    /* renamed from: c */
    private static String m14441c(String str) {
        try {
            return new JSONArray(str).get(0).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: b */
    public static int m14438b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 240;
        }
        if (str.toLowerCase().endsWith("p")) {
            str = str.substring(0, str.length() - 1);
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 240;
        }
    }
}
