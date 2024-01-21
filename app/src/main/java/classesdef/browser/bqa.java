package classesdef.browser;

import android.app.Application;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bqa */
class bqa extends bpy {

    /* renamed from: a */
    private static XmlPullParser f16367a;

    /* renamed from: b */
    private final String f16368b;

    bqa(Application application) {
        super(application, "ISO-8859-1");
        this.f16368b = application.getString(R.string.suggestion);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo23530a(String str, String str2) {
        return "https://suggestqueries.google.com/complete/search?output=toolbar&oe=latin1&hl=" + str2 + "&q=" + str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23531a(InputStream inputStream, List<bmg> list) throws XmlPullParserException, IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        XmlPullParser b = m18875b();
        b.setInput(bufferedInputStream, "ISO-8859-1");
        int i = 0;
        for (int eventType = b.getEventType(); eventType != 1; eventType = b.next()) {
            if (eventType == 2 && "suggestion".equals(b.getName())) {
                String attributeValue = b.getAttributeValue((String) null, "data");
                list.add(new bmg(this.f16368b + " \"" + attributeValue + '\"', attributeValue, R.drawable.ic_downloader_search));
                i++;
                if (i >= 5) {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private static synchronized XmlPullParser m18875b() throws XmlPullParserException {
        XmlPullParser xmlPullParser;
        synchronized (bqa.class) {
            if (f16367a == null) {
                XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
                newInstance.setNamespaceAware(true);
                f16367a = newInstance.newPullParser();
            }
            xmlPullParser = f16367a;
        }
        return xmlPullParser;
    }
}
