package classesdef.browser;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import java.util.List;

import javax.inject.Inject;

import classesdef.browser.download.bmn;
import classesdef.browser.download.boi;
import classesdef.browser.tab.C4123d;
import classesdef.browser.tab.C4892v;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

/* renamed from: bms */
public class bms {
    @Inject
    public

    /* renamed from: a */
    bmj f15691a;
    @Inject
    public

    /* renamed from: b */
            bmn f15692b;
    @Inject
    public

    /* renamed from: c */
    bpn f15693c;

    /* renamed from: bms$a */
    public enum C3912a {
        FOREGROUND,
        BACKGROUND,
        INCOGNITO
    }

    @Inject
    public bms() {
        BrowserApp.m15129g().mo21493a(this);
    }

    /* renamed from: a */
    public void mo23118a(final Activity activity, final bmf bmf, String str) {
        if (!str.startsWith("file://") || !str.endsWith("bookmarks.html")) {
            this.f15691a.mo23063a(str).mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<bmg>() {
                /* renamed from: a */
                public void mo21366a(bmg bmg) {
                    if (bmg != null) {
                        bms.this.mo23117a(activity, bmf, bmg);
                    }
                }
            });
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        String substring = lastPathSegment.substring(0, (lastPathSegment.length() - "bookmarks.html".length()) - 1);
        bmg bmg = new bmg();
        bmg.mo23044a(true);
        bmg.mo23049c(substring);
        bmg.mo23041a((int) R.drawable.ic_downloader_folder);
        bmg.mo23047b("folder://" + substring);
        mo23120b(activity, bmf, bmg);
    }

    /* renamed from: a */
    public void mo23117a(final Activity activity, final bmf bmf, final bmg bmg) {
        final Activity activity2 = activity;
        final bmf bmf2 = bmf;
        final bmg bmg2 = bmg;
        bmr.m18086a(activity, (int) R.string.action_bookmarks, new bmr.C3878b(R.string.dialog_open_new_tab) {
            /* renamed from: a */
            public void mo21391a() {
                bmf.mo21300a(C3912a.FOREGROUND, bmg.mo23052e());
            }
        }, new bmr.C3878b(R.string.dialog_open_background_tab) {
            /* renamed from: a */
            public void mo21391a() {
                bmf.mo21300a(C3912a.BACKGROUND, bmg.mo23052e());
            }
        }, new bmr.C3878b(R.string.action_share) {
            /* renamed from: a */
            public void mo21391a() {
                new bqj(activity).mo23567a(bmg.mo23052e(), bmg.mo23054f());
            }
        }, new bmr.C3878b(R.string.dialog_copy_link) {
            /* renamed from: a */
            public void mo21391a() {
                BrowserApp.m15128a(activity, bmg.mo23052e());
            }
        }, new bmr.C3878b(R.string.dialog_remove_bookmark) {
            /* renamed from: a */
            public void mo21391a() {
                bms.this.f15691a.mo23065b(bmg).mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<Boolean>() {
                    /* renamed from: a */
                    public void mo21366a(Boolean bool) {
                        bql.m18952a(bool);
                        if (bool.booleanValue()) {
                            bmf.mo21311b(bmg);
                        }
                    }
                });
            }
        }, new bmr.C3878b(R.string.dialog_edit_bookmark) {
            /* renamed from: a */
            public void mo21391a() {
                bms.this.m18097c(activity2, bmf2, bmg2);
            }
        });
    }

    /* renamed from: b */
    public void mo23121b(Activity activity, final bmf bmf, String str) {
        bmr.m18086a(activity, (int) R.string.action_download, new bmr.C3878b(R.string.dialog_delete_all_downloads) {
            /* renamed from: a */
            public void mo21391a() {
                bms.this.f15692b.mo23096a().mo21839a(C4740s.m21407e()).mo21842b(C4740s.m21406d()).mo23840a(new C4123d() {
                    /* renamed from: a */
                    public void mo21414a() {
                        bmf.mo21290C();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18097c(Activity activity, bmf bmf, bmg bmg) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle((int) R.string.title_edit_bookmark);
        final View inflate = View.inflate(activity, R.layout.dialog_edit_bookmark, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.bookmark_title);
        editText.setText(bmg.mo23054f());
        final EditText editText2 = (EditText) inflate.findViewById(R.id.bookmark_url);
        editText2.setText(bmg.mo23052e());
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) inflate.findViewById(R.id.bookmark_folder);
        autoCompleteTextView.setHint(R.string.folder);
        autoCompleteTextView.setText(bmg.mo23048c());
        final Activity activity2 = activity;
        final bmg bmg2 = bmg;
        final bmf bmf2 = bmf;
        this.f15691a.mo23068c().mo24966a(C4740s.m21407e()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<List<String>>() {
            /* renamed from: a */
            public void mo21366a(List<String> list) {
                bql.m18952a(list);
                ArrayAdapter arrayAdapter = new ArrayAdapter(activity2, 17367050, list);
                autoCompleteTextView.setThreshold(1);
                autoCompleteTextView.setAdapter(arrayAdapter);
                builder.setView(inflate);
                builder.setPositiveButton((CharSequence) activity2.getString(R.string.action_ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        bmg bmg = new bmg();
                        bmg.mo23049c(editText.getText().toString());
                        bmg.mo23047b(editText2.getText().toString());
                        bmg.mo23047b(editText2.getText().toString());
                        bmg.mo23043a(autoCompleteTextView.getText().toString());
                        bms.this.f15691a.mo23058a(bmg2, bmg).mo21839a(C4740s.m21407e()).mo21842b(C4740s.m21406d()).mo23840a(new C4123d() {
                            /* renamed from: a */
                            public void mo21414a() {
                                bmf2.mo21289B();
                            }
                        });
                    }
                });
                bmr.m18088a(activity2, builder.show());
            }
        });
    }

    /* renamed from: b */
    public void mo23120b(Activity activity, final bmf bmf, final bmg bmg) {
        final Activity activity2 = activity;
        final bmf bmf2 = bmf;
        final bmg bmg2 = bmg;
        bmr.m18086a(activity, (int) R.string.action_folder, new bmr.C3878b(R.string.dialog_rename_folder) {
            /* renamed from: a */
            public void mo21391a() {
                bms.this.m18098d(activity2, bmf2, bmg2);
            }
        }, new bmr.C3878b(R.string.dialog_remove_folder) {
            /* renamed from: a */
            public void mo21391a() {
                bms.this.f15691a.mo23067c(bmg.mo23054f()).mo21839a(C4740s.m21407e()).mo21842b(C4740s.m21406d()).mo23840a(new C4123d() {
                    /* renamed from: a */
                    public void mo21414a() {
                        bmf.mo21311b(bmg);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18098d(Activity activity, final bmf bmf, final bmg bmg) {
        bmr.m18085a(activity, R.string.title_rename_folder, R.string.hint_title, bmg.mo23054f(), R.string.action_ok, new bmr.C3877a() {
            /* renamed from: a */
            public void mo21426a(String str) {
                if (!TextUtils.isEmpty(str)) {
                    String f = bmg.mo23054f();
                    bmg bmg = new bmg();
                    bmg.mo23049c(str);
                    bmg.mo23047b("folder://" + str);
                    bmg.mo23043a(bmg.mo23048c());
                    bmg.mo23044a(true);
                    bms.this.f15691a.mo23059a(f, str).mo21839a(C4740s.m21407e()).mo21842b(C4740s.m21406d()).mo23840a(new C4123d() {
                        /* renamed from: a */
                        public void mo21414a() {
                            bmf.mo21289B();
                        }
                    });
                }
            }
        });
    }

    /* renamed from: c */
    public void mo23122c(final Activity activity, final bmf bmf, final String str) {
        bmr.m18086a(activity, (int) R.string.action_history, new bmr.C3878b(R.string.dialog_open_new_tab) {
            /* renamed from: a */
            public void mo21391a() {
                bmf.mo21300a(C3912a.FOREGROUND, str);
            }
        }, new bmr.C3878b(R.string.dialog_open_background_tab) {
            /* renamed from: a */
            public void mo21391a() {
                bmf.mo21300a(C3912a.BACKGROUND, str);
            }
        }, new bmr.C3878b(R.string.action_share) {
            /* renamed from: a */
            public void mo21391a() {
                new bqj(activity).mo23567a(str, (String) null);
            }
        }, new bmr.C3878b(R.string.dialog_copy_link) {
            /* renamed from: a */
            public void mo21391a() {
                BrowserApp.m15128a(activity, str);
            }
        }, new bmr.C3878b(R.string.dialog_remove_from_history) {
            /* renamed from: a */
            public void mo21391a() {
                bmq.m18071a(str).mo21839a(C4740s.m21407e()).mo21842b(C4740s.m21406d()).mo23840a(new C4123d() {
                    /* renamed from: a */
                    public void mo21414a() {
                        bmf.mo21330n();
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public void mo23119a(final Activity activity, final bmf bmf, final String str, String str2, WebView webView) {
        final Activity activity2 = activity;
        final String str3 = str;
        final WebView webView2 = webView;
        bmr.m18087a(activity, str.replace("http://", ""), new bmr.C3878b(R.string.dialog_open_new_tab) {
            /* renamed from: a */
            public void mo21391a() {
                bmf.mo21300a(C3912a.FOREGROUND, str);
            }
        }, new bmr.C3878b(R.string.dialog_open_background_tab) {
            /* renamed from: a */
            public void mo21391a() {
                bmf.mo21300a(C3912a.BACKGROUND, str);
            }
        }, new bmr.C3878b(R.string.action_share) {
            /* renamed from: a */
            public void mo21391a() {
                new bqj(activity).mo23567a(str, (String) null);
            }
        }, new bmr.C3878b(R.string.dialog_copy_link) {
            /* renamed from: a */
            public void mo21391a() {
                BrowserApp.m15128a(activity, str);
            }
        }, new bmr.C3878b(R.string.dialog_download_image) {
            /* renamed from: a */
            public void mo21391a() {
                boi.m18319b().mo23267a(activity2, str3, webView2.getUrl(), webView2.getTitle());
            }
        });
    }

    /* renamed from: d */
    public void mo23123d(final Activity activity, final bmf bmf, final String str) {
        bmr.m18087a(activity, str, new bmr.C3878b(R.string.dialog_open_new_tab) {
            /* renamed from: a */
            public void mo21391a() {
                bmf.mo21300a(C3912a.FOREGROUND, str);
            }
        }, new bmr.C3878b(R.string.dialog_open_background_tab) {
            /* renamed from: a */
            public void mo21391a() {
                bmf.mo21300a(C3912a.BACKGROUND, str);
            }
        }, new bmr.C3878b(R.string.action_share) {
            /* renamed from: a */
            public void mo21391a() {
                new bqj(activity).mo23567a(str, (String) null);
            }
        }, new bmr.C3878b(R.string.dialog_copy_link) {
            /* renamed from: a */
            public void mo21391a() {
                BrowserApp.m15128a(activity, str);
            }
        });
    }
}
