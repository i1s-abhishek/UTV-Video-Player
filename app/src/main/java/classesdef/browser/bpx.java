package classesdef.browser;

import android.app.Application;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bpx */
class bpx extends bpy {

    /* renamed from: a */
    private final String f16352a;

    bpx(Application application) {
        super(application, "UTF-8");
        this.f16352a = application.getString(R.string.suggestion);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo23530a(String str, String str2) {
        return "http://suggestion.baidu.com/s?wd=" + str + "&action=opensearch";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23531a(InputStream inputStream, List<bmg> list) {
        JSONArray jSONArray = null;
        try {
            jSONArray = new JSONArray(bqi.m18946a(inputStream, "GBK")).getJSONArray(1);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int length = jSONArray.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String string = null;
            try {
                string = jSONArray.getString(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            list.add(new bmg(this.f16352a + " \"" + string + '\"', string, R.drawable.ic_downloader_search));
            i2++;
            if (i2 < 5) {
                i++;
            } else {
                return;
            }
        }
    }
}
