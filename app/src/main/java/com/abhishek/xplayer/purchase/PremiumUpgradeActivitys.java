package com.abhishek.xplayer.purchase;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.abhishek.xplayer.application.BaseActivity;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import classesdef.ads.atd;
import hdplayer.xdplayer.videoplayer.R;

public class PremiumUpgradeActivitys extends BaseActivity implements PurchasesUpdatedListener {

    private PremiumUpgradeActivitys.C4491a f14602b;

    public Handler handler = new Handler();

    private  boolean f14608hh;
    public ProgressDialog progressDialog;
    public Button premiumUpgradeMonthlyBtn;
    public Button premiumUpgradeAnnualyBtn;
    public Button premiumUpgradeLifetimeBtn;
    public BillingClient billingClient;
    public SkuDetails skuDetails = null;
    private AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener = new AcknowledgePurchaseResponseListener() {
        @Override
        public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {
            if (billingResult.getResponseCode() == 0) {
                progressDialog = ProgressDialog.show(PremiumUpgradeActivitys.this, (CharSequence) null, PremiumUpgradeActivitys.this.getString(R.string.premium_upgrade_processing), true, false);
                progressDialog.cancel();
                Toast.makeText(PremiumUpgradeActivitys.this, PremiumUpgradeActivitys.this.getString(R.string.purchased_success), 1).show();
                atd.adRemoved("adRemoved", true);
                //   User.getInstance(PremiumUpgradeActivitys.this).setRemoveAd(true);
             //   User.getInstance(PremiumUpgradeActivitys.this).save(PremiumUpgradeActivitys.this);
                m18595g();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 21) {
            getWindow().getDecorView().setBackgroundColor(-1);
        }
        setContentView(R.layout.preminum_upgrade_main);
        setButton();
    }


    private void setButton() {
        this.premiumUpgradeLifetimeBtn = (Button) findViewById(R.id.premium_upgrade_lifetime_btn);
        this.premiumUpgradeLifetimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkuDetails kVar = (SkuDetails) premiumUpgradeLifetimeBtn.getTag();
                if (kVar != null) {
                    Log.e("abhipurches","calllb");
                    m1925a( PremiumUpgradeActivitys.this, kVar);
                }
            }
        });
        this.premiumUpgradeMonthlyBtn = (Button) findViewById(R.id.premium_upgrade_monthly_btn);
        this.premiumUpgradeMonthlyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkuDetails kVar = (SkuDetails) premiumUpgradeAnnualyBtn.getTag();
                if (kVar != null) {
                    Log.e("abhipurches","calllc");
                    m1925a(PremiumUpgradeActivitys.this, kVar);
                }
            }
        });
        this.premiumUpgradeAnnualyBtn = (Button) findViewById(R.id.premium_upgrade_annually_btn);
        this.premiumUpgradeAnnualyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkuDetails kVar = (SkuDetails) premiumUpgradeMonthlyBtn.getTag();
                if (kVar != null) {
                    Log.e("abhipurches","callld");
                    m1925a((Activity) PremiumUpgradeActivitys.this, kVar);
                }
            }
        });
        premiumUpgradeButtonEnable(false);
        Log.e("abhipurches","oncreate1");
        // ((Button) findViewById(R.id.premium_upgrade_old_paid_btn)).setOnClickListener(new C0630ei(this));
        startPurches();
    }
    public void startPurches() {
        m18585a((Runnable) new C4489N(PremiumUpgradeActivitys.this));
    }

    private void m18585a(Runnable runnable) {
        Log.e("abhipurches","premium_4");
        if (f14608hh) {
            Log.e("abhipurches","premium_4_");
            runnable.run();
            return;
        }
        if (this.billingClient == null) {
            Log.e("abhipurches","premium_5");
            BillingClient.Builder a = BillingClient.newBuilder((Context) this);
            a.enablePendingPurchases();
            a.setListener(this);
            this.billingClient = a.build();
        }
        Log.e("abhipurches","premium_6");
        this.billingClient.startConnection( new BillingClientListener(this, runnable));
    }
    class BillingClientListener implements BillingClientStateListener {

        /* renamed from: a */
        final /* synthetic */ Runnable f14594a;

        /* renamed from: b */
        final /* synthetic */ PremiumUpgradeActivitys f14595b;

        BillingClientListener(PremiumUpgradeActivitys o, Runnable runnable) {
            this.f14595b = o;
            this.f14594a = runnable;
        }

        /* renamed from: a */
        public void onBillingSetupFinished(BillingResult g) {
            Log.e("abhipurches","premium_6");
            if (g.getResponseCode() == 0) {
                Log.e("abhipurches","premium_7");
               f14608hh = true;
                this.f14594a.run();
            }
        }

        /* renamed from: a */
        public void onBillingServiceDisconnected() {
            Log.e("abhipurches","premium_8");
          f14608hh = false;
        }
    }
    class C4489N implements Runnable {

        /* renamed from: a */
        final /* synthetic */ PremiumUpgradeActivitys f14600a;

        C4489N(PremiumUpgradeActivitys o) {
            this.f14600a = o;
        }

        public void run() {
            try {
                // Toast.makeText(this.f14600a.activity, "onSkuDetailsResponse3", Toast.LENGTH_SHORT).show();
                if (this.f14600a.skuDetails == null) {
                    this.f14600a.getSku();
                    return;
                }
                BillingFlowParams.Builder j = BillingFlowParams.newBuilder();
                j.setSkuDetails(this.f14600a.skuDetails);
                this.f14600a.billingClient.launchBillingFlow(PremiumUpgradeActivitys.this, j.build());
            } catch (Exception e) {
      //          C4529n.m18804a(PremiumUpgradeActivitys.this, "BillingClient", e.getMessage());
            }
        }
    }
    public void getSku() {
        handler.post(new C0634em());
        m18585a((Runnable) new C4487L(this));
    }

    class C0634em implements Runnable {

        public void run() {
           progressDialog = ProgressDialog.show(PremiumUpgradeActivitys.this, (CharSequence) null, PremiumUpgradeActivitys.this.getString(R.string.premium_upgrade_loading_info), true, false);
        }
    }

    class C4487L implements Runnable {

        /* renamed from: a */
        final /* synthetic */ PremiumUpgradeActivitys f14598a;

        C4487L(PremiumUpgradeActivitys o) {
            this.f14598a = o;
        }

        public void run() {
            try {
                // Toast.makeText(PremiumUpgradeActivitys.this, "onSkuDetailsResponse2", Toast.LENGTH_SHORT).show();
                if (this.f14598a.billingClient == null && f14608hh) {
                    Log.e("abhipurches","calllaaa1");
                    this.f14598a.mo23201c();
                }
                Log.e("abhipurches","calllaaa2");
                SkuDetailsParams.Builder c = SkuDetailsParams.newBuilder();
                ArrayList arrayList = new ArrayList();
                arrayList.add("lifetime_subscription");
                c.setSkusList((List<String>) arrayList);
                c.setType(BillingClient.SkuType.INAPP);
                this.f14598a.billingClient.querySkuDetailsAsync(c.build(),  new C4486K(this));
                 arrayList.clear();
                arrayList.add("monthly_subscription");
                arrayList.add("yearly_subscription");
                SkuDetailsParams.Builder d2 = SkuDetailsParams.newBuilder();
                d2.setSkusList((List<String>) arrayList).setType("subs");
                this.f14598a.billingClient.querySkuDetailsAsync(d2.build(),  new C4486K(this));


            } catch (Exception e) {
            //    C4529n.m18804a(PremiumUpgradeActivitys.this, "BillingClient", e.getMessage());
            }
        }
    }

    class C4486K implements SkuDetailsResponseListener {

        /* renamed from: a */
        final /* synthetic */ C4487L f14597a;

        C4486K(C4487L l) {
            this.f14597a = l;
        }

        /* renamed from: a */
        public void onSkuDetailsResponse(BillingResult g, List<SkuDetails> list) {
            Log.e("abhipurches","calllaaa3");
            if (g.getResponseCode() == 0) {
                Log.e("abhipurches","calllaaa4a");
                for (SkuDetails next : list) {
                    Log.e("abhipurches","calllaaa4");
                    String a = next.getSku();
                    String d = next.getPrice();
                    Log.e("abhipurches_list","list="+String.valueOf(list));

                    if ("lifetime_subscription".equals(a)) {
                        Log.e("abhipurches","lifetime_subscription"+String.valueOf(next));
                        this.f14597a.f14598a.skuDetails = next;
                        String plainString = new BigDecimal((double) ((((float) next.getPriceAmountMicros()) / 0.2f) / 1000000.0f)).setScale(2, 4).toPlainString();
                      //  User.getInstance(PremiumUpgradeActivitys.this).setRemoveAdPrice(d);
                      //  User.getInstance(PremiumUpgradeActivitys.this).setRemoveAdOriginalPrice(plainString);
                 //       User.getInstance(PremiumUpgradeActivitys.this).save(PremiumUpgradeActivitys.this);
                        this.f14597a.f14598a.m18595g();
                       premiumUpgradeLifetimeBtn.setVisibility(0);
                        premiumUpgradeLifetimeBtn.setEnabled(true);
                        premiumUpgradeLifetimeBtn.setText(String.valueOf(getString(R.string.premium_upgrade_lifetime_btn_text)) + " " + d);
                        premiumUpgradeLifetimeBtn.setTag(next);
                    }
                    else if ("monthly_subscription".equals(a)) {
                        Log.e("abhipurches","monthly_subscription");
                        premiumUpgradeAnnualyBtn.setVisibility(0);
                        premiumUpgradeAnnualyBtn.setEnabled(true);
                        premiumUpgradeAnnualyBtn.setText(String.valueOf(getString(R.string.premium_upgrade_monthly_btn_text)) + " " + d);
                        premiumUpgradeAnnualyBtn.setTag(next);
                    }
                    else if ("yearly_subscription".equals(a)) {
                        Log.e("abhipurches","yearly_subscription");
                        premiumUpgradeMonthlyBtn.setVisibility(0);
                        premiumUpgradeMonthlyBtn.setEnabled(true);
                        premiumUpgradeMonthlyBtn.setText(String.valueOf(getString(R.string.premium_upgrade_annually_btn_text)) + " " + d);
                        premiumUpgradeMonthlyBtn.setTag(next);
                    }
                }
                if(list.isEmpty()){
            Runnable runnable= new Runnable(){
                       @Override
                       public void run() {
                           Toast.makeText(PremiumUpgradeActivitys.this, R.string.premium_upgrade_error_msg, Toast.LENGTH_SHORT).show();
                           onBackPressed();
                       }
                   };
                   new Handler().postDelayed(runnable,500);
                }
            }
            try {
                progressDialog.cancel();
            } catch (Exception e) {
            }
        }
    }

    public void mo23201c() {
        m18585a(new Runnable() {
            @Override
            public void run() {
                mo23202d();
            }
        });
    }
    public void mo23202d() {
        m18585a((Runnable) new C4485J(this));
    }
    public void m1925a(Activity activity, SkuDetails kVar) {
        this.billingClient.launchBillingFlow(activity, BillingFlowParams.newBuilder().setSkuDetails(kVar).build());
    }

    class C4485J implements Runnable {

        /* renamed from: a */
        final /* synthetic */ PremiumUpgradeActivitys f14596a;

        C4485J(PremiumUpgradeActivitys o) {
            this.f14596a = o;
        }

        public void run() {
            boolean z;
            try {
                if (this.f14596a.billingClient != null) {

                    ArrayList inAppArrayList = new ArrayList();
                    ArrayList subAppArrayList = new ArrayList();
                    QueryPurchasesParams inAppParams = QueryPurchasesParams.newBuilder()
                            .setProductType(BillingClient.SkuType.INAPP)
                            .build();
                    QueryPurchasesParams subsParams = QueryPurchasesParams.newBuilder()
                            .setProductType(BillingClient.SkuType.SUBS)
                            .build();
                    CountDownLatch latch = new CountDownLatch(2); // Creating a latch for two async queries

                    billingClient.queryPurchasesAsync(inAppParams, (billingResult, purchases) -> {
                        if (purchases != null && !purchases.isEmpty()) {
                            for (Purchase purchase : purchases) {
                                if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED) {
                                    inAppArrayList.add(purchase);
                                }
                            }
                        }
                        latch.countDown(); // Decrement the latch count
                    });

                    billingClient.queryPurchasesAsync(subsParams, (billingResult, purchases) -> {
                        if (purchases != null && !purchases.isEmpty()) {
                            for (Purchase purchase : purchases) {
                                if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED) {
                                    subAppArrayList.add(purchase);
                                }
                            }
                        }
                        latch.countDown(); // Decrement the latch count
                    });

                    try {
                        latch.await(); // Wait until both async queries are finished
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Iterator it = inAppArrayList.iterator();
                    Iterator it2 = subAppArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        if ("lifetime_subscription".equals(((Purchase) it.next()).getSkus().get(0))) {
                            z = true;
                            break;
                        }
                        if ("monthly_subscription".equals(((Purchase) it2.next()).getSkus().get(0))) {
                            z = true;
                            break;
                        }
                        if ("yearly_subscription".equals(((Purchase) it2.next()).getSkus().get(0))) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        //Toast.makeText(this.f14596a.activity, "onSkuDetailsResponse4", Toast.LENGTH_SHORT).show();
                        atd.adRemoved("adRemoved", false);
                        //  User.getInstance(PremiumUpgradeActivitys.this).setRemoveAd(false);
                        //   User.getInstance(PremiumUpgradeActivitys.this).save(PremiumUpgradeActivitys.this);
                        this.f14596a.getSku();
                    } else {
                        atd.adRemoved("adRemoved", true);
                        //  User.getInstance(PremiumUpgradeActivitys.this).setRemoveAd(true);
                        //    User.getInstance(PremiumUpgradeActivitys.this).save(PremiumUpgradeActivitys.this);
                        this.f14596a.m18595g();
                    }

                }
            } catch (Exception e) {
                // C4529n.m18804a(PremiumUpgradeActivitys.this, "BillingClient", e.getMessage());
            }
        }

    }

    public void premiumUpgradeButtonEnable(boolean z) {
        findViewById(R.id.premium_upgrade_lifetime_btn).setEnabled(z);
        findViewById(R.id.premium_upgrade_monthly_btn).setEnabled(z);
        findViewById(R.id.premium_upgrade_annually_btn).setEnabled(z);
    }
    public interface C4491a {
        void mo20988a();
    }
    public void m18595g() {
        PremiumUpgradeActivitys.C4491a aVar = this.f14602b;
        if (aVar != null) {
            aVar.mo20988a();
        }
    }


    public void onPurchasesUpdated(BillingResult g, List<Purchase> list) {
        if (g.getResponseCode() == 0 && list != null) {
            for (Purchase a : list) {
                m18584a(a);
            }
        } else if (g.getResponseCode() != 1) {
            m18596h();
        }
    }

    private void m18596h() {
        try {
            C3459c cVar = new C3459c(this);
            cVar.setTitle((int) R.string.purchased_failed_title);
            cVar.setMessage((int) R.string.purchased_failed);
            cVar.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            cVar.setNegativeButton((int) R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            cVar.create();
            cVar.show();
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
    }
    public static String m1937b(String str) {
        return str.equals("lifetime_subscription") ? "inapp" : "subs";
    }

    public void onDestroy() {
        super.onDestroy();
        Log.e("abhipurches","ondistroy1");
        if (this.billingClient != null) {
            Log.e("abhipurches","ondistroy2");
            this.billingClient.endConnection();
            this.billingClient = null;
        }
    }
    private void m18584a(Purchase m) {
        if (m.getPurchaseState() == 1 && !m.isAcknowledged()) {
            AcknowledgePurchaseParams.Builder c = AcknowledgePurchaseParams.newBuilder();
            c.setPurchaseToken(m.getPurchaseToken());
            this.billingClient.acknowledgePurchase(c.build(), this.acknowledgePurchaseResponseListener);
        }
    }

}
