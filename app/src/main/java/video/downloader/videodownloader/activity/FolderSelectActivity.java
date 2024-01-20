package video.downloader.videodownloader.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import classesdef.browser.bbc;
import classesdef.browser.bng;
import classesdef.browser.bnh;
import classesdef.browser.boo;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.bpb;
import classesdef.browser.bqw;
import classesdef.xdplayer.bpj;
import hdplayer.vlcplayer.videoplayer.R;

public class FolderSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private String f13495a = "";
    public String f13496b;

    private ListView f13497c;

    private bng f13498d;

    private TextView f13499e;

    private RecyclerView f13500f;

    private bnh f13501g;
    public ArrayList<String> f13502h = new ArrayList<>();
    public ArrayList<String> f13503i = new ArrayList<>();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.setting_folder_select);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mo21400a();
    }

    /* renamed from: a */
    public void mo21400a() {
        this.f13500f = (RecyclerView) findViewById(R.id.rv_cur_path);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.f13500f.setLayoutManager(linearLayoutManager);
        this.f13501g = new bnh(this, this.f13503i);
        this.f13500f.setAdapter(this.f13501g);
        this.f13497c = (ListView) findViewById(R.id.lv_folder_list);
        this.f13498d = new bng(this, this.f13502h);
        this.f13497c.setAdapter(this.f13498d);
        findViewById(R.id.ll_folder_up).setOnClickListener(this);
        findViewById(R.id.tv_cancel).setOnClickListener(this);
        this.f13499e = (TextView) findViewById(R.id.tv_select);
        this.f13499e.setOnClickListener(this);
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.f13495a = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        this.f13496b = boo.m18379c(this);
        ArrayList<String> a = bpb.m18488a(this);
        if (a.size() > 1 && this.f13496b.equals(a.get(1))) {
            this.f13496b = this.f13495a;
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            bqw.m19014a((Context) this, (int) R.string.sd_unmount);
        } else if (this.f13496b.equals("")) {
            this.f13496b = getCacheDir().getAbsolutePath() + "/Download/";
            if (this.f13496b == null || this.f13496b.equals("")) {
                m14977a(this.f13495a, false);
            } else {
                m14977a(this.f13496b, false);
            }
        } else {
            m14977a(this.f13496b, false);
        }
        this.f13497c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FolderSelectActivity.this.f13496b.equals("/")) {
                    FolderSelectActivity folderSelectActivity = FolderSelectActivity.this;
                    String unused = folderSelectActivity.f13496b = FolderSelectActivity.this.f13496b + ((String) FolderSelectActivity.this.f13502h.get(i));
                } else {
                    FolderSelectActivity folderSelectActivity2 = FolderSelectActivity.this;
                    String unused2 = folderSelectActivity2.f13496b = FolderSelectActivity.this.f13496b + "/" + ((String) FolderSelectActivity.this.f13502h.get(i));
                }
                FolderSelectActivity.this.m14977a(FolderSelectActivity.this.f13496b, false);
            }
        });
        this.f13501g.mo23193a(new bnh.C3944a() {
            /* renamed from: a */
            public void mo21404a(int i) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 <= i; i2++) {
                    sb.append((String) FolderSelectActivity.this.f13503i.get(i2));
                    if (i2 < i) {
                        sb.append("/");
                    }
                }
                FolderSelectActivity.this.m14977a(sb.toString(), true);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_folder_up) {
            BrowserLogEvent.downloaderLogEvent(this, "foler select activity", "touch folder up");
            m14981b();
        } else if (id == R.id.tv_cancel) {
            BrowserLogEvent.downloaderLogEvent(this, "foler select activity", "cancel");
            finish();
        } else if (id == R.id.tv_select) {
            BrowserLogEvent.downloaderLogEvent(this, "foler select activity", "select folder");
            File file = new File(this.f13496b);
            if (file.exists() && file.canWrite()) {
                bpj.m18578a((Context) this).mo23382c(this.f13496b);
                bpj.m18578a((Context) this).mo23375b((Context) this);
            }
            setResult(-1, new Intent());
            finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0060 A[Catch:{ Exception -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069 A[Catch:{ Exception -> 0x0080 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m14981bb() {
        /*
            r9 = this;
            r0 = 0
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0080 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ Exception -> 0x0080 }
            int r2 = r1.indexOf(r2)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x0080 }
            int r3 = r1.lastIndexOf(r3)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r2 = r1.substring(r2, r3)     // Catch:{ Exception -> 0x0080 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0054 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0054 }
            if (r3 == 0) goto L_0x0052
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0052
            boolean r4 = r3.isDirectory()     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0052
            java.io.File[] r3 = r3.listFiles()     // Catch:{ Exception -> 0x0054 }
            if (r3 == 0) goto L_0x0052
            int r4 = r3.length     // Catch:{ Exception -> 0x0054 }
            r5 = 0
            r6 = 0
        L_0x0035:
            if (r5 >= r4) goto L_0x005d
            r7 = r3[r5]     // Catch:{ Exception -> 0x0050 }
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ Exception -> 0x0050 }
            if (r7 == 0) goto L_0x004d
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r8 = "sdcard"
            boolean r7 = r7.contains(r8)     // Catch:{ Exception -> 0x0050 }
            if (r7 == 0) goto L_0x004d
            int r6 = r6 + 1
        L_0x004d:
            int r5 = r5 + 1
            goto L_0x0035
        L_0x0050:
            r3 = move-exception
            goto L_0x0056
        L_0x0052:
            r6 = 0
            goto L_0x005d
        L_0x0054:
            r3 = move-exception
            r6 = 0
        L_0x0056:
            bbc r4 = p000.bbc.m15886a()     // Catch:{ Exception -> 0x0080 }
            r4.mo21879a((android.content.Context) r9, (java.lang.Throwable) r3)     // Catch:{ Exception -> 0x0080 }
        L_0x005d:
            r3 = 1
            if (r6 <= r3) goto L_0x0069
            java.lang.String r1 = r9.f13496b     // Catch:{ Exception -> 0x0080 }
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0080 }
            if (r1 == 0) goto L_0x0072
            return r3
        L_0x0069:
            java.lang.String r2 = r9.f13496b     // Catch:{ Exception -> 0x0080 }
            boolean r1 = r2.equals(r1)     // Catch:{ Exception -> 0x0080 }
            if (r1 == 0) goto L_0x0072
            return r3
        L_0x0072:
            java.lang.String r1 = r9.f13496b     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = r9.m14979b((java.lang.String) r1)     // Catch:{ Exception -> 0x0080 }
            r9.f13496b = r1     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = r9.f13496b     // Catch:{ Exception -> 0x0080 }
            r9.m14977a((java.lang.String) r1, (boolean) r0)     // Catch:{ Exception -> 0x0080 }
            return r0
        L_0x0080:
            r1 = move-exception
            java.lang.String r2 = android.os.Environment.getExternalStorageState()
            java.lang.String r3 = "mounted"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0094
            r2 = 2131624368(0x7f0e01b0, float:1.8875914E38)
            p000.bqw.m19014a((android.content.Context) r9, (int) r2)
            goto L_0x0099
        L_0x0094:
            java.lang.String r2 = r9.f13495a
            r9.m14977a((java.lang.String) r2, (boolean) r0)
        L_0x0099:
            bbc r2 = p000.bbc.m15886a()
            r2.mo21879a((android.content.Context) r9, (java.lang.Throwable) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.activity.FolderSelectActivity.m14981b():boolean");
    }
    private boolean m14981cb() {
        int i2;
        Exception e2;
        File[] listFiles;
        try {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            String substring = absolutePath.substring(absolutePath.indexOf(File.separator), absolutePath.lastIndexOf(File.separator));
            try {
                File file = new File(substring);
                if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    i2 = 0;
                    if (i2 <= 1) {
                        if (this.f13496b.equals(substring)) {
                            return true;
                        }
                    } else if (this.f13496b.equals(absolutePath)) {
                        return true;
                    }
                    this.f13496b = m14979b(this.f13496b);
                    m14977a(this.f13496b, false);
                    return false;
                }
                i2 = 0;
                for (File file2 : listFiles) {
                    try {
                        String absolutePath2 = file2.getAbsolutePath();
                        if (absolutePath2 != null && absolutePath2.toLowerCase().contains("sdcard")) {
                            i2++;
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        bbc.m15886a().mo21879a(this, e2);
                        if (i2 <= 1) {
                        }
                        this.f13496b = m14979b(this.f13496b);
                        m14977a(this.f13496b, false);
                        return false;
                    }
                }
                if (i2 <= 1) {
                }
                this.f13496b = m14979b(this.f13496b);
                m14977a(this.f13496b, false);
                return false;
            } catch (Exception e4) {
                e2 = e4;
                i2 = 0;
                bbc.m15886a().mo21879a(this, e2);
                if (i2 <= 1) {
                }
                this.f13496b = m14979b(this.f13496b);
                m14977a(this.f13496b, false);
                return false;
            }
        } catch (Exception e5) {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                bqw.m19014a((Context) this, (int) R.string.sd_unmount);
            } else {
                m14977a(this.f13495a, false);
            }
            bbc.m15886a().mo21879a(this, e5);
            return false;
        }
    }
    private boolean m14981b() {
        try {
            final String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            final String substring = absolutePath.substring(absolutePath.indexOf(File.separator), absolutePath.lastIndexOf(File.separator));
            int n3 = 0;
            Label_0165: {
                int n2 = 0;
                Label_0153: {
                    try {
                        final File file = new File(substring);
                        if (file != null && file.exists() && file.isDirectory()) {
                            final File[] listFiles = file.listFiles();
                            if (listFiles != null) {
                                final int length = listFiles.length;
                                int n = 0;
                                n2 = 0;
                                while (true) {
                                    n3 = n2;
                                    if (n < length) {
                                        try {
                                            final String absolutePath2 = listFiles[n].getAbsolutePath();
                                            int n4 = n2;
                                            if (absolutePath2 != null) {
                                                final boolean contains = absolutePath2.toLowerCase().contains("sdcard");
                                                n4 = n2;
                                                if (contains) {
                                                    n4 = n2 + 1;
                                                }
                                            }
                                            ++n;
                                            n2 = n4;
                                            continue;
                                        }
                                        catch (Exception ex) {
                                            break Label_0153;
                                        }
                                        //break;
                                    }
                                    break Label_0165;
                                }
                            }
                        }
                        n3 = 0;
                        break Label_0165;
                    }
                    catch (Exception ex) {
                        n2 = 0;
                    }
                }
                final Exception ex=null;
                bbc.m15886a().mo21879a((Context)this, (Throwable)ex);
                n3 = n2;
            }
            if (n3 > 1) {
                if (this.f13496b.equals(substring)) {
                    return true;
                }
            }
            else if (this.f13496b.equals(absolutePath)) {
                return true;
            }
            this.m14977a(this.f13496b = this.m14979b(this.f13496b), false);
            return false;
        }
        catch (Exception ex2) {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                bqw.m19014a((Context) this, 2131624368);
            }
            else {
                m14977a(this.f13495a,  false);
            }
            bbc.m15886a().mo21879a((Context)this, (Throwable)ex2);
            return false;
        }
    }
    /* renamed from: a */
    private String m14974a(String str) {
        try {
            return str.substring(str.lastIndexOf("/") + 1);
        } catch (Exception e) {
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
            return null;
        }
    }

    /* renamed from: b */
    private String m14979b(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == 0) {
            return "/";
        }
        try {
            return str.substring(0, lastIndexOf);
        } catch (Exception e) {
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
            return null;
        }
    }

    /* renamed from: c */
    private ArrayList<String> m14982c(String str) {
        File[] listFiles;
        String a;
        ArrayList<String> arrayList = new ArrayList<>();
        if (!Environment.getExternalStorageState().equals("mounted")) {
            bqw.m19014a((Context) this, (int) R.string.sd_unmount);
            return arrayList;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String substring = absolutePath.substring(absolutePath.indexOf(File.separator), absolutePath.lastIndexOf(File.separator));
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory() && (a = m14974a(file2.getAbsolutePath())) != null) {
                    if (!str.equals(substring)) {
                        arrayList.add(a);
                    } else if (a.toLowerCase().contains("sdcard")) {
                        arrayList.add(a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14977a(String str, boolean z) {
        if (z) {
            this.f13496b = str.replaceFirst("Root Folder", this.f13495a);
        } else {
            this.f13496b = str;
        }
        this.f13502h.clear();
        this.f13502h.addAll(m14982c(this.f13496b));
        this.f13498d.notifyDataSetChanged();
        String[] split = this.f13496b.replace(this.f13495a, "Root Folder").split("/");
        this.f13503i.clear();
        Collections.addAll(this.f13503i, split);
        this.f13501g.notifyDataSetChanged();
        this.f13500f.scrollToPosition(this.f13503i.size() - 1);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (!m14981b()) {
            return true;
        }
        finish();
        return true;
    }
}
