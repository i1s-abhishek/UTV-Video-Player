package classesdef.browser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import net.i2p.android.router.service.IRouterState;
import net.i2p.android.router.service.State;

import hdplayer.xdplayer.videoplayer.R;

/* renamed from: bgl */
public class bgl {

    /* renamed from: a */
    private final Context f14580a;

    /* renamed from: b */
    private final boolean f14581b;

    /* renamed from: c */
    private boolean f14582c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IRouterState f14583d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C3740a f14584e;

    /* renamed from: f */
    private final ServiceConnection f14585f = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IRouterState unused = bgl.this.f14583d = IRouterState.Stub.asInterface(iBinder);
            Log.i("I2PHelperLib", "Bound to I2P Android");
            if (bgl.this.f14584e != null) {
                bgl.this.f14584e.mo22274a();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.w("I2PHelperLib", "I2P Android disconnected unexpectedly");
            IRouterState unused = bgl.this.f14583d = null;
        }
    };

    /* renamed from: bgl$a */
    public interface C3740a {
        /* renamed from: a */
        void mo22274a();
    }

    public bgl(Context context) {
        this.f14580a = context;
        this.f14581b = false;
    }

    /* renamed from: a */
    public void mo22265a(C3740a aVar) {
        this.f14584e = aVar;
        mo22263a();
    }

    /* renamed from: a */
    public void mo22263a() {
        Log.i("I2PHelperLib", "Binding to I2P Android");
        Intent f = m16571f();
        if (f != null) {
            Log.i("I2PHelperLib", f.toString());
            try {
                this.f14582c = this.f14580a.bindService(f, this.f14585f, 1);
                if (!this.f14582c) {
                    Log.w("I2PHelperLib", "Could not bind: bindService failed");
                }
            } catch (SecurityException unused) {
                this.f14583d = null;
                this.f14582c = false;
                Log.w("I2PHelperLib", "Could not bind: I2P Android version is too old");
            }
        } else {
            Log.w("I2PHelperLib", "Could not bind: I2P Android not installed");
        }
    }

    /* renamed from: f */
    private Intent m16571f() {
        Intent intent = new Intent("net.i2p.android.router.service.IRouterState");
        if (m16570a("net.i2p.android")) {
            intent.setClassName("net.i2p.android", "net.i2p.android.router.service.RouterService");
        } else if (m16570a("net.i2p.android.donate")) {
            intent.setClassName("net.i2p.android.donate", "net.i2p.android.router.service.RouterService");
        } else if (m16570a("net.i2p.android.router")) {
            intent.setClassName("net.i2p.android.router", "net.i2p.android.router.service.RouterService");
        } else {
            intent = null;
        }
        if (this.f14581b && m16570a("net.i2p.android.debug")) {
            Log.w("I2PHelperLib", "Using debug build of I2P Android");
            intent.setClassName("net.i2p.android.debug", "net.i2p.android.router.service.RouterService");
        }
        return intent;
    }

    /* renamed from: b */
    public void mo22266b() {
        if (this.f14582c) {
            this.f14580a.unbindService(this.f14585f);
        }
        this.f14582c = false;
        this.f14584e = null;
    }

    /* renamed from: c */
    public boolean mo22267c() {
        return (this.f14581b && m16570a("net.i2p.android.debug")) || m16570a("net.i2p.android") || m16570a("net.i2p.android.donate") || m16570a("net.i2p.android.router");
    }

    /* renamed from: a */
    private boolean m16570a(String str) {
        try {
            this.f14580a.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: d */
    public boolean mo22268d() {
        if (this.f14583d == null) {
            return false;
        }
        try {
            return this.f14583d.isStarted();
        } catch (RemoteException e) {
            Log.w("I2PHelperLib", "Failed to communicate with I2P Android", e);
            return false;
        }
    }

    /* renamed from: a */
    public void mo22264a(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.start_i2p_android).setMessage(R.string.would_you_like_to_start_i2p_android).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.startActivityForResult(new Intent("net.i2p.android.router.START_I2P"), 9857);
            }
        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

    /* renamed from: e */
    public boolean mo22269e() {
        if (this.f14583d == null) {
            return false;
        }
        try {
            if (this.f14583d.getState() == State.ACTIVE) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            Log.w("I2PHelperLib", "Failed to communicate with I2P Android", e);
            return false;
        }
    }
}
