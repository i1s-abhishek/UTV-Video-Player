package classesdef.browser;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: bmi */
public class bmi {
    /* renamed from: a */
    public static List<bmg> m18024a(Context context) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        IOException e;
        ArrayList arrayList = new ArrayList();
        try {
            inputStream = context.getResources().openRawResource(R.raw.default_bookmarks);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(readLine);
                            bmg bmg = new bmg();
                            bmg.mo23049c(jSONObject.getString("title"));
                            bmg.mo23047b(jSONObject.getString("url"));
                            bmg.mo23043a(jSONObject.getString("folder"));
                            bmg.mo23046b(jSONObject.getInt("order"));
                            bmg.mo23041a((int) R.drawable.ic_bookmark);
                            arrayList.add(bmg);
                        } catch (JSONException e2) {
                            Log.e("BookmarkExporter", "Can't parse line " + readLine, e2);
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                bqw.m19016a((Closeable) bufferedReader);
                bqw.m19016a((Closeable) inputStream);
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader = null;
            e = e5;
            inputStream = null;
            Log.e("BookmarkExporter", "Error reading the bookmarks file", e);
            bqw.m19016a((Closeable) bufferedReader);
            bqw.m19016a((Closeable) inputStream);
            return arrayList;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
            bufferedReader = null;
            bqw.m19016a((Closeable) bufferedReader);
            bqw.m19016a((Closeable) inputStream);
          //  throw th;
        }
        bqw.m19016a((Closeable) bufferedReader);
        bqw.m19016a((Closeable) inputStream);
        return arrayList;
    }
}
