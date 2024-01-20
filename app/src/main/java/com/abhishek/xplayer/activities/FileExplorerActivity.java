package com.abhishek.xplayer.activities;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.abhishek.inplayer.bean.VideoPlayListBean;
import com.abhishek.xplayer.ad.FunnyAd;
import com.abhishek.xplayer.application.AppActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.content.C2624a;
import com.abhishek.xplayer.content.VideoManager;
import com.abhishek.xplayer.content.MediaFileInfo;
import com.abhishek.xplayer.fragments.DirectoryPageFragment;
import com.abhishek.xplayer.fragments.PermissionFragment;
import com.abhishek.xplayer.fragments.SettingFragment;
import com.abhishek.xplayer.fragments.VideoListPrivateVideoListFragment;
import com.abhishek.xplayer.fragments.VideoFolderFragment;
import com.abhishek.xplayer.service.C2779a;
import com.mopub.mobileads.VastIconXmlManager;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import classesdef.ads.C4786mv;
import classesdef.eventbus.awj;
import classesdef.xdplayer.ServerConfigSharedPrefrence;
import classesdef.xdplayer.atg;
import classesdef.xdplayer.avt;
import classesdef.xdplayer.avu;
import classesdef.xdplayer.awp;
import classesdef.xdplayer.axe;
import classesdef.xdplayer.axh;
import classesdef.xdplayer.AllPermission;
import classesdef.xdplayer.axv;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;


public class FileExplorerActivity extends AppActivity implements axh.C1349a {


    public static String fragmentName;


    private avt f10247c;


    private axh f10248d;


    private ImageView adButton;


    private View f10250f;


    private C2779a.C2786a f10251g = new C2779a.C2786a() {

        public void mo17671a() {
        }
        public void mo17672a(long j) {
        }


        public boolean mo17675d() {
            return false;
        }


        public void mo17673b() {
            if (!FileExplorerActivity.this.isFinishing()) {
                FileExplorerActivity.this.m11628h();
            }
        }


        public void mo17674c() {
            if (!FileExplorerActivity.this.isFinishing()) {
                FileExplorerActivity.this.m11629i();
            }
        }
    };


    private LinkedList<C2543b> f10252h = new LinkedList<>();


    private final C2542a f10253i = new C2542a();

    public interface C2543b {
    }


    public int loadActivity() {
        return R.layout.activity_app;
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(Build.VERSION.SDK_INT < 21);
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10248d = new axh(this, this, 500);
        this.f10248d.mo10973a();
        this.f10247c = new avu();
        if (!AllPermission.m7381a(MyApplication.getApplicationContext_(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.body, PermissionFragment.m12280a()).commitAllowingStateLoss();
            return;
        }

        setTheme();
        if (ServerConfigSharedPrefrence.m23693m(this) == 1) {
            C4786mv.m23718a().mo26046a(this, R.mipmap.ic_launcher, "Welcome to HD Player", getResources().getColor(R.color.md_orange_400), new C4786mv.C4792b() {
                /* renamed from: a */
                public void mo16852a() {
                }

                /* renamed from: a */
                public void mo16853a(boolean z) {
                }
            });
        }

    }


    public void setTheme() {
        VideoFolderFragment kVar = new VideoFolderFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.body, kVar);
        beginTransaction.commitAllowingStateLoss();
        m11625e();
        if (SettingFragment.f10817a) {
            SettingFragment.f10817a = false;
            loadFragmet(getSupportFragmentManager(), new SettingFragment(), true);
        }
    }


    public AnimationDrawable adButtonAds(int i) {

        if (i != 0) {
            if (!(this.adButton == null || this.adButton.getVisibility() == i)) {
                this.adButton.setVisibility(i);
            }
            Log.e("Animatio_adButton","one"+String.valueOf(i));
            return null;
        } else if (this.f10253i.f10257b) {
            Log.e("Animatio_adButton","two"+String.valueOf(i));
            return null;
        } else {
            Log.e("Animatio_adButton","three"+String.valueOf(i));
            if (this.adButton == null) {
                Log.e("Animatio_adButton","three1"+String.valueOf(i));
                this.adButton = (ImageView) findViewById(R.id.btn_app_wall);
                this.adButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Log.e("Animatio_adButton","__name_ "+String.valueOf(FileExplorerActivity.fragmentName));
                        FunnyAd.loadFunnyAd(FileExplorerActivity.this, false, FileExplorerActivity.fragmentName);
                    }
                });
            }
            if (this.adButton.getVisibility() != View.VISIBLE) {
                Log.e("Animatio_adButton2","three"+String.valueOf(i));
                this.adButton.setVisibility(View.VISIBLE);
            }
            return (AnimationDrawable) this.adButton.getDrawable();
        }
    }


    private void m11625e() {
        awp awp = new awp();
        awp.mo10872b(this);
        awp.mo10871a(this);
    }


    public void mo17667b() {
        this.f10247c.mo10824a(this, this.bacgrountActivity);
    }


    public void onResume() {
        super.onResume();
        m11626f();
        atg.m18405a(this);
    }


    public void onPause() {
        super.onPause();
        m11627g();
    }


    public void onDestroy() {
        super.onDestroy();
        this.f10248d.mo10974b();
        this.f10252h = null;
    }


    private void m11623a(String str, boolean z, boolean z2) {
        loadFragmet(getSupportFragmentManager(), DirectoryPageFragment.m12259a(str, z), z2);
    }


    public void mo17664a(C2624a aVar, MediaFileInfo mediaFileInfo, Fragment fragment, int i) {
        int indexOf;
        //Toast.makeText(this, "call2", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(this,  PlayerActivity.class);
        intent.putExtra("path", mediaFileInfo.mo17890d());
        intent.putExtra("name", mediaFileInfo.mo17892e());
        if (mediaFileInfo.mo17880a() != null) {
            intent.putExtra("dbBean", mediaFileInfo.mo17880a());
        }
        if (mediaFileInfo.mo17889c()) {
            intent.putExtra("private", true);
            intent.putExtra("originalPath", mediaFileInfo.f10497b);
        }
        if (aVar != null && aVar.mo17924a() > 0) {
            int a = aVar.mo17924a();
            int i2 = 0;
            if (aVar.f10548d && a > 100 && (indexOf = aVar.f10547c.indexOf(mediaFileInfo)) >= 0) {
                i2 = Math.max(0, indexOf - 50);
                int i3 = i2 + 100;
                if (i3 < a) {
                    a = i3;
                } else {
                    i2 = a - 100;
                }
            }
            ArrayList arrayList = new ArrayList(a - i2);
            while (i2 < a) {
                MediaFileInfo mediaFileInfo2 = aVar.f10547c.get(i2);
                if (mediaFileInfo2 != null) {
                    VideoPlayListBean videoPlayListBean = new VideoPlayListBean();
                    videoPlayListBean.f9813a = mediaFileInfo2.mo17890d();
                    videoPlayListBean.f9815c = mediaFileInfo2.mo17892e();
                    videoPlayListBean.f9814b = mediaFileInfo2.mo17893f();
                    videoPlayListBean.f9816d = mediaFileInfo2.mo17886b();
                    videoPlayListBean.f9818f = mediaFileInfo2.mo17880a() == null ? null : mediaFileInfo2.mo17880a().f10535h;
                    videoPlayListBean.f9817e = mediaFileInfo2.f10497b;
                    videoPlayListBean.f9819g = mediaFileInfo2.mo17880a() == null ? -1 : mediaFileInfo2.mo17880a().f10528a;
                    arrayList.add(videoPlayListBean);
                }
                i2++;
            }
            intent.putExtra("playList", arrayList);
            intent.putExtra("listName", aVar.f10546b);
        }
        if (i != 0) {
            fragment.startActivityForResult(intent, i);
        } else {
            try {
                fragment.startActivity(intent);
            } catch (Exception unused) {
                intent.removeExtra("playList");
                intent.removeExtra("listName");
                fragment.startActivity(intent);
            }
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("fileExt", axe.m7324e(mediaFileInfo.mo17892e()));
        treeMap.put(VastIconXmlManager.DURATION, String.valueOf(mediaFileInfo.mo17893f()));
        LogEvents.m18494b("VideoInfo", (Map<String, String>) treeMap);
    }


    public void mo17663a(C2624a aVar) {
        VideoListPrivateVideoListFragment a = VideoListPrivateVideoListFragment.m12406a(aVar, false);
        FragmentTransaction customAnimations = getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_bottom_in, 0, 0, R.anim.fragment_bottom_out);
        customAnimations.replace(R.id.body, a);
        customAnimations.addToBackStack((String) null);
        customAnimations.commitAllowingStateLoss();
    }


    public void mo17666a(String str) {
        m11623a(str, true, true);
    }


    public void mo17665a(DirectoryPageFragment.C2684a aVar) {
        if (aVar.f10691c) {
            m11623a(aVar.f10689a, false, true);
        } else if (aVar.f10695g) {
            //Toast.makeText(this, "call", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(this, PlayerActivity.class);
            intent.putExtra("path", aVar.f10689a);
            intent.putExtra("name", aVar.f10690b);
            if (aVar.f10696h != null) {
                intent.putExtra("dbBean", aVar.f10696h);
            }
            startActivity(intent);
            VideoManager.m12181a(aVar.f10689a, true);
            if (aVar.f10696h != null) {
                TreeMap treeMap = new TreeMap();
                treeMap.put("fileExt", axe.m7324e(aVar.f10690b));
                treeMap.put(VastIconXmlManager.DURATION, String.valueOf(aVar.f10696h.f10534g));
                LogEvents.m18494b("VideoInfo", (Map<String, String>) treeMap);
            }
        } else {
            axv.m7439a("Unknown file");
        }
    }
    public void mo10977a(Set<Uri> set) {
        EventBus.getDefault().post(new awj(true));
    }
    private void m11626f() {
        if (C2779a.m12613a().mo18137c() == null) {
            m11629i();
        } else {
            m11628h();
        }
        C2779a.m12613a().mo18133a(this.f10251g);
    }


    private void m11627g() {
        C2779a.m12613a().mo18134b(this.f10251g);
    }


    public void m11628h() {
        if (this.f10250f == null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.layout_bottom);
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
            this.f10250f = LayoutInflater.from(this).inflate(R.layout.fragment_audio_player_mini, viewGroup, false);
            viewGroup.addView(this.f10250f);
        }
    }



    public void m11629i() {
        if (this.f10250f != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.layout_bottom);
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
            this.f10250f = null;
        }
    }
    public C2542a mo17661a(C2543b bVar) {
        this.f10252h.add(bVar);
        return this.f10253i;
    }


    public void mo17668b(C2543b bVar) {
        this.f10252h.remove(bVar);
    }

    public class C2542a {

        public boolean f10257b;

        public C2542a() {
        }
    }
}
