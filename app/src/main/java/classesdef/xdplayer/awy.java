package classesdef.xdplayer;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder;
import com.abhishek.xplayer.application.MyApplication;

import java.io.IOException;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: awy */
public class awy implements ResourceDecoder<ImageVideoWrapper, Bitmap> {

    /* renamed from: a */
    private FileDescriptorBitmapDecoder f6165a;

    /* renamed from: a */
    public String getId() {
        return "CustomVideoBitmapDecoder";
    }

    public awy(String str, Context context, long j) {
        if (context != null) {
            this.f6165a = new FileDescriptorBitmapDecoder(new C1311a(str, j, context), Glide.get(context).getBitmapPool(), DecodeFormat.DEFAULT);
        }
    }

    /* renamed from: a */
    public Resource<Bitmap> decode(ImageVideoWrapper ddVar, int i, int i2) throws IOException {
        ParcelFileDescriptor b = ddVar.getFileDescriptor();
        if (b == null || this.f6165a == null) {
            return null;
        }

            return this.f6165a.decode(b, i, i2);


    }

    /* renamed from: awy$a */
    private static class C1311a extends VideoBitmapDecoder {

        /* renamed from: a */
        private String f6166a;

        /* renamed from: b */
        private long f6167b;

        /* renamed from: c */
        private int f6168c;

        /* renamed from: d */
        private Context f6169d;

        private C1311a(String str, long j, Context context) {
            this.f6168c = -1;
            this.f6166a = str;
            this.f6167b = j;
            this.f6169d = context.getApplicationContext();
        }

        /* renamed from: a */
        public Bitmap decode(ParcelFileDescriptor parcelFileDescriptor, BitmapPool cdVar, int i, int i2, DecodeFormat azVar) {
            Bitmap bitmap;
            Exception exc;
            Bitmap bitmap2;
            if (this.f6168c >= 0) {
                return null;
            }
            Long a = awy.m7233b(this.f6169d, this.f6166a);
            if (a != null) {
                bitmap = awy.m7232b(this.f6169d, a.longValue(), Math.max(i, i2) < 96 ? 3 : 1);
            } else {
                bitmap = null;
            }
            if (axw.m7448a(bitmap)) {
                return bitmap;
            }
            try {
                bitmap2 = super.decode(parcelFileDescriptor, cdVar, i, i2, azVar);
                exc = null;
            } catch (Exception e) {
                exc = e;
                bitmap2 = bitmap;
            }
            if (bitmap2 != null || exc == null) {
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    return bitmap2;
                }
                Bitmap decodeResource = BitmapFactory.decodeResource(MyApplication.getApplicationContext_().getResources(), R.mipmap.video_default_thumb);
                if (decodeResource == null || decodeResource.isRecycled()) {
                    return null;
                }
                return decodeResource;
            } else if (exc instanceof IOException) {
               // throw ((IOException) exc);
            } else {
              //  throw new IOException(exc);
            }
            return bitmap;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Long m7233b(Context context, String str) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data LIKE ?", new String[]{str}, (String) null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
                        axy.m7468a(cursor);
                        return valueOf;
                    }
                } catch (Exception e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        axy.m7468a(cursor);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        axy.m7468a(cursor);
                        throw th;
                    }
                }
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
            e.printStackTrace();
            axy.m7468a(cursor);
            return null;
        } catch (Throwable th2) {
            Throwable th = th2;
            cursor = null;
            th = th;
            axy.m7468a(cursor);
           // throw th;
        }
        axy.m7468a(cursor);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Bitmap m7232b(Context context, long j, int i) {
        try {
            return MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(), j, i, new BitmapFactory.Options());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
