package classesdef.browser;

import android.app.Application;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import hdplayer.vlcplayer.videoplayer.R;


@Deprecated
/* renamed from: bmk */
public class bmk {
    /* renamed from: a */
    public static List<bmg> m18038a(Application application) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        IOException e;
        File filesDir = application.getFilesDir();
        ArrayList arrayList = new ArrayList();
        File file = new File(filesDir, "bookmarks.dat");
        try {
            if (!file.exists() || !file.isFile()) {
                bqw.m19016a((Closeable) null);
                bqw.m19016a((Closeable) null);
                return arrayList;
            }
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
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
                            Log.e("LegacyBookmarkManager", "Can't parse line " + readLine, e2);
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                th = th;
                bqw.m19016a((Closeable) bufferedReader);
                bqw.m19016a((Closeable) fileInputStream);
                throw th;
            }
            bqw.m19016a((Closeable) bufferedReader);
            bqw.m19016a((Closeable) fileInputStream);
            file.delete();
            return arrayList;
        } catch (IOException e5) {
            bufferedReader = null;
            e = e5;
            fileInputStream = null;
            Log.e("LegacyBookmarkManager", "Error reading the bookmarks file", e);
            bqw.m19016a((Closeable) bufferedReader);
            bqw.m19016a((Closeable) fileInputStream);
            file.delete();
            return arrayList;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            bufferedReader = null;
            th = th;
            bqw.m19016a((Closeable) bufferedReader);
            bqw.m19016a((Closeable) fileInputStream);
          //  throw th;
        }
        return null;
    }
}
