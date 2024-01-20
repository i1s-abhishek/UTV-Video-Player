package classesdef.browser;

import android.app.Application;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: bpz */
final class bpz extends bpy {

    /* renamed from: a */
    private final String f16359a;

    bpz(Application application) {
        super(application, "UTF-8");
        this.f16359a = application.getString(R.string.suggestion);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo23530a(String str, String str2) {
        return "https://duckduckgo.com/ac/?q=" + str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23531a(InputStream inputStream, List<bmg> list) throws IOException, JSONException {
        JSONArray jSONArray = new JSONArray(bqi.m18946a(inputStream, "UTF-8"));
        int length = jSONArray.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String string = jSONArray.getJSONObject(i).getString("phrase");
            list.add(new bmg(this.f16359a + " \"" + string + '\"', string, R.drawable.ic_downloader_search));
            i2++;
            if (i2 < 5) {
                i++;
            } else {
                return;
            }
        }
    }
}
