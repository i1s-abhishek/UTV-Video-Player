package classesdef.xdplayer;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: axf */
public class axf {
    /* renamed from: a */
    public static Map<String, JSONObject> m7326a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (jSONObject instanceof JSONObject) {
                hashMap.put(next, (JSONObject) obj);
            }
        }
        return hashMap;
    }
}
