package classesdef.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.ConsentStatus;
import com.mopub.common.privacy.PersonalInfoManager;
import com.cc.promote.activity.PolicyActivity;

import classesdef.xdplayer.ServerConfigSharedPrefrence;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: mv */
public class C4786mv {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PersonalInfoManager f17959a;

    /* renamed from: mv$a */
    private static final class C4791a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C4786mv f17970a = new C4786mv();
    }

    /* renamed from: mv$b */
    public interface C4792b {
        /* renamed from: a */
        void mo16852a();

        /* renamed from: a */
        void mo16853a(boolean z);
    }

    private C4786mv() {
    }

    /* renamed from: a */
    public static C4786mv m23718a() {
        return C4791a.f17970a;
    }

    /* renamed from: a */
    public void mo26045a(Context context, String str) {
        try {
            MoPub.initializeSdk(context, new SdkConfiguration.Builder(str).build(), m23715a(context));
            this.f17959a = MoPub.getPersonalInformationManager();
            Log.e("addInitilize done2",String.valueOf(str));
        } catch (Exception e) {
            Log.e("addInitilize done3",String.valueOf(e));
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private SdkInitializationListener m23715a(final Context context) {
        return new SdkInitializationListener() {
            public void onInitializationFinished() {
                Log.d(MoPubLog.LOGTAG, "SDK initialized.");
                if (ServerConfigSharedPrefrence.m23693m(context) != -1 || C4786mv.this.f17959a == null) {
                    return;
                }
                if (C4786mv.this.f17959a.shouldShowConsentDialog()) {
                    ServerConfigSharedPrefrence.m23680e(context, 1);
                } else {
                    ServerConfigSharedPrefrence.m23680e(context, 0);
                }
            }
        };
    }

    /* renamed from: a */
    public boolean mo26046a(final Context context, int i, String str, int i2, final C4792b bVar) {
        try {
            if (ServerConfigSharedPrefrence.m23693m(context) == 1) {
                if (ServerConfigSharedPrefrence.m19736o(context) == ConsentStatus.UNKNOWN) {
                    final Runnable r1 = new Runnable() {
                        public void run() {
                            if (context != null) {
                                if (C4786mv.this.f17959a == null) {
                                    PersonalInfoManager unused = C4786mv.this.f17959a = MoPub.getPersonalInformationManager();
                                }
                                if (C4786mv.this.f17959a != null) {
                                    C4786mv.this.f17959a.grantConsent();
                                    ServerConfigSharedPrefrence.m23666a(context, ConsentStatus.EXPLICIT_YES);
                                    if (bVar != null) {
                                        bVar.mo16853a(true);
                                    }
                                }
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View inflate = LayoutInflater.from(context).inflate(R.layout.gdpr_dialog, (ViewGroup) null, false);
                    builder.setView(inflate);
                    builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                            r1.run();
                        }
                    });
                    final AlertDialog show = builder.show();
                    ((ImageView) inflate.findViewById(R.id.main_icon)).setImageResource(i);
                    TextView textView = (TextView) inflate.findViewById(R.id.auth_title);
                    if (str != null) {
                        textView.setText(str);
                    }
                    TextView textView2 = (TextView) inflate.findViewById(R.id.continue_button);
                    textView2.setBackgroundColor(i2);
                    textView2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            r1.run();
                            show.dismiss();
                        }
                    });
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            if (bVar != null) {
                bVar.mo16852a();
            }
            return false;
        }
    }

    /* renamed from: a */
    public static void m23719a(Context context, String str, int i, int i2, String str2, String str3) {
        Intent intent = new Intent(context, PolicyActivity.class);
        intent.putExtra("url", str3);
        intent.putExtra("statusBarColor", i);
        intent.putExtra("color", i2);
        intent.putExtra("email", str2);
        intent.putExtra("title", str);
        context.startActivity(intent);
    }
}
