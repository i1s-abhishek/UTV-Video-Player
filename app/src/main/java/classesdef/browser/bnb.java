package classesdef.browser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

import okhttp3.OkHttpClient;

/* renamed from: bnb */
class bnb {

    /* renamed from: a */
    private final BitmapFactory.Options f15817a = new BitmapFactory.Options();

    /* renamed from: b */
    private final OkHttpClient f15818b = new OkHttpClient();

    bnb() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo23141a(File file) {
        return BitmapFactory.decodeFile(file.getPath(), this.f15817a);
    }
}
