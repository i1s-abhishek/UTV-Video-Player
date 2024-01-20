package classesdef.browser;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: bot */
public class bot {
    /* renamed from: a */
    public static String m18410a(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            long blockCount = (long) statFs.getBlockCount();
            return context.getString(R.string.free, new Object[]{Formatter.formatFileSize(context, (blockCount - ((long) statFs.getAvailableBlocks())) * blockSize), Formatter.formatFileSize(context, blockSize * blockCount)});
        } catch (VerifyError e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        } catch (Error e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m18411a(Context context, String str) {
        try {
            StatFs statFs = new StatFs(str);
            long blockSize = (long) statFs.getBlockSize();
            long blockCount = (long) statFs.getBlockCount();
            return context.getString(R.string.free, new Object[]{Formatter.formatFileSize(context, (blockCount - ((long) statFs.getAvailableBlocks())) * blockSize), Formatter.formatFileSize(context, blockSize * blockCount)});
        } catch (VerifyError e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        } catch (Error e3) {
            e3.printStackTrace();
            return "";
        }
    }
}
