package classesdef.browser;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;

import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class BrowserData {
    private static BrowserData f16077a = null;
    public static int f16078b = 0;
    public static String f16079c = "";
    private static String userAgent = "";
    private static String mozilla = "";
    private static String videosx = "";
    private static String videosxn = "";
    private static String videosub = "";
    private static String videotub = "";
    private static String videoyoup = "";
    private static String videoham = "";
    private static String videopre = "";
    private static String liveleak = "";
    private static String videoyouj = "";
    private static String videot8 = "";
    private static String videotbang = "";
    private static String tiktok = "";
    private static String javascript = "";
    private static String onlyfan = "";
    private static String javascriptSetStyle = "";
    private static String shaivideo = "";
    private static String getToken = "";

    
    public void mo23297a(Throwable th) {
    }

    private BrowserData() {
    }
    
    public static synchronized BrowserData m18385a() {
        BrowserData bor;
        synchronized (BrowserData.class) {
            if (f16077a == null) {
                f16077a = new BrowserData();
            }
            bor = f16077a;
        }
        return bor;
    }

    
    public static synchronized void m18388a(final Context context, String str) {
        synchronized (BrowserData.class) {
            try {
                Logger.e(str, new Object[0]);
                String str2 = "\r\n" + m18389b() + "-->";
                if (f16078b < 10) {
                    f16079c += str2 + str;
                    f16078b++;
                } else {
                    new Thread() {
                        public void run() {
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                String unused = BrowserData.f16079c = "";
                                int unused2 = BrowserData.f16078b = 0;
                                FileOutputStream fileOutputStream = new FileOutputStream(BrowserData.m18404o(context), true);
                                fileOutputStream.write((BrowserData.f16079c + "").getBytes());
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                Logger.e("write log time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }

    
    public static String m18389b() {
        Time time = new Time();
        time.setToNow();
        int i = time.year;
        int i2 = time.monthDay;
        int i3 = time.hour;
        int i4 = time.minute;
        int i5 = time.second;
        return i + "-" + (time.month + 1) + "-" + i2 + " " + i3 + ":" + i4 + ":" + i5;
    }

    
    public static void m18387a(Context context) throws IOException {
        File file = new File(boo.m18377a(context) + "/crash.log");
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            int available = fileInputStream.available();
            fileInputStream.close();
            if (((double) available) / 1024.0d > 1000.0d) {
                file.delete();
                file.createNewFile();
                return;
            }
            return;
        }
        file.createNewFile();
    }
    
    public static File m18404o(Context context) {
        try {
            m18387a(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(boo.m18377a(context) + "/crash.log");
    }
    public static String m18390b(Context context) {
        if (TextUtils.isEmpty(userAgent)) {
            m18405p(context);
        }
        return userAgent;
    }

    
    public static String m18392c(Context context) {
        if (TextUtils.isEmpty(mozilla)) {
            m18405p(context);
        }
        return mozilla;
    }

    
    public static String m18393d(Context context) {
        if (TextUtils.isEmpty(videosx)) {
            m18405p(context);
        }
        return videosx;
    }

    
    public static String m18394e(Context context) {
        if (TextUtils.isEmpty(videosxn)) {
            m18405p(context);
        }
        return videosxn;
    }

    
    public static String m18395f(Context context) {
        if (TextUtils.isEmpty(videosub)) {
            m18405p(context);
        }
        return videosub;
    }

    
    public static String m18396g(Context context) {
        if (TextUtils.isEmpty(videopre)) {
            m18405p(context);
        }
        return videopre;
    }
    public static String m18397h(Context context) {
        if (TextUtils.isEmpty(videotub)) {
            m18405p(context);
        }
        return videotub;
    }

    
    public static String m18398i(Context context) {
        if (TextUtils.isEmpty(videoyoup)) {
            m18405p(context);
        }
        return videoyoup;
    }

    
    public static String m18399j(Context context) {
        if (TextUtils.isEmpty(videoham)) {
            m18405p(context);
        }
        return videoham;
    }

    
    public static String m18400k(Context context) {
        if (TextUtils.isEmpty(liveleak)) {
            m18405p(context);
        }
        return liveleak;
    }

    
    public static String m18401l(Context context) {
        if (TextUtils.isEmpty(videoyouj)) {
            m18405p(context);
        }
        return videoyouj;
    }

    
    public static String m18402m(Context context) {
        if (TextUtils.isEmpty(videot8)) {
            m18405p(context);
        }
        return videot8;
    }

    
    public static String m21105n(Context context) {
        if (TextUtils.isEmpty(videotbang)) {
            m18405p(context);
        }
        return videotbang;
    }
    public static String m21106o(Context context) {
        if (TextUtils.isEmpty(tiktok)) {
            m18405p(context);
        }
        return tiktok;
    }

    
    public static String m21107p(Context context) {
        if (TextUtils.isEmpty(javascript)) {
            m18405p(context);
        }
        return javascript;
    }

    
    public static String m21108q(Context context) {
        if (TextUtils.isEmpty(onlyfan)) {
            m18405p(context);
        }
        return onlyfan;
    }

    
    public static String m21109r(Context context) {
        if (TextUtils.isEmpty(javascriptSetStyle)) {
            m18405p(context);
        }
        return javascriptSetStyle;
    }

    
    public static String m21110s(Context context) {
        if (TextUtils.isEmpty(shaivideo)) {
            m18405p(context);
        }
        return shaivideo;
    }

    
    public static String m21111t(Context context) {
        if (TextUtils.isEmpty(getToken)) {
            m18405p(context);
        }
        return getToken;
    }

    private static void m18405p(Context context) {
        InputStream inputStream;
        ObjectInputStream objectInputStream;
        Throwable th;
        Exception e2;
        try {
            inputStream = context.getResources().getAssets().open("data");
            try {
                objectInputStream = new ObjectInputStream(inputStream);
            }
            catch (Exception e3) {
                objectInputStream = null;
                e2 = e3;
                try {
                    e2.printStackTrace();
                    if (objectInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
            catch (Throwable th3) {
                objectInputStream = null;
                th = th3;
                if (objectInputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
            try {
              //  Log.e("JSONObject_data0","__"+String.valueOf(bqw.m19022b((String) objectInputStream.readObject())));
               // Log.e("JSONObject_data1","__"+String.valueOf(objectInputStream.readObject()));
                JSONObject jSONObject = new JSONObject(bqw.m19022b((String) objectInputStream.readObject()));
                Log.e("abhishek_json1","__"+String.valueOf(jSONObject));
//                Log.e("JSONObject_data2","__"+String.valueOf(bqw.m19022b((String) objectInputStream.readObject())));
                userAgent = jSONObject.optString("method_0");
                Log.e("JSONObject_method_0",String.valueOf(userAgent));
                mozilla = jSONObject.optString("method_1");
                Log.e("JSONObject_method_0",String.valueOf(mozilla));
                videosx = jSONObject.optString("method_2");
                videosxn = jSONObject.optString("method_3");
                videosub = jSONObject.optString("method_4");
                videotub = jSONObject.optString("method_5");
                videoyoup = jSONObject.optString("method_6");
                videoham = jSONObject.optString("method_7");
                videopre = jSONObject.optString("method_8");
                liveleak = jSONObject.optString("method_9");
                videoyouj = jSONObject.optString("method_10");
                videot8 = jSONObject.optString("method_11");
                videotbang = jSONObject.optString("method_12");
                tiktok = jSONObject.optString("method_13");
                javascript = jSONObject.optString("method_14");
                onlyfan = jSONObject.optString("method_15");
                javascriptSetStyle = jSONObject.optString("method_16");
                shaivideo = jSONObject.optString("method_17");
                Log.e("JSONObject_method_17",String.valueOf(shaivideo));

                getToken = jSONObject.optString("method_18");
                Log.e("JSONObject_method_18",String.valueOf(getToken));

                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e5) {
                e2 = e5;
                e2.printStackTrace();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (Exception e6) {
            objectInputStream = null;
            e2 = e6;
            inputStream = null;
            e2.printStackTrace();
            if (objectInputStream != null) {
            }
            if (inputStream != null) {
            }
        } catch (Throwable th4) {
            objectInputStream = null;
            th = th4;
            inputStream = null;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                    //throw th;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           // throw th;
        }
    }
}
