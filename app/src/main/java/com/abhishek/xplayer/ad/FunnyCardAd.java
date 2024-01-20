package com.abhishek.xplayer.ad;

import android.content.Context;
import android.graphics.Bitmap;


import com.abhishek.xplayer.application.MyApplication;

import java.util.Iterator;
import java.util.LinkedList;


public class FunnyCardAd extends AppAbstractAds<FunnyCardNativeAd> {

    
    private static FunnyCardAd funnyCardAd;

    
    private LinkedList<C2248a> linkedList = new LinkedList<>();

    
    interface C2248a {
        
        void mo16974a(Bitmap bitmap);
    }

    
    
    public String mo16910a() {
        return "Funny";
    }

    
    public static FunnyCardAd createInstance() {
        if (funnyCardAd == null) {
            funnyCardAd = new FunnyCardAd();
        }
        return funnyCardAd;
    }

    private FunnyCardAd() {
    }

    
    public FunnyCardNativeAd mo16927c() {
        FunnyCardNativeAd oVar = (FunnyCardNativeAd) super.mo16927c();
        if (oVar == null || !oVar.mo16905d()) {
            return new FunnyCardNativeAd(MyApplication.getApplicationContext_());
        }
        return oVar;
    }

   
    public FunnyCardNativeAd mo16909a(Context context, AppAbstractInterface<FunnyCardNativeAd> qVar) {
        FunnyCardNativeAd oVar = new FunnyCardNativeAd(context);
        oVar.mo16996a(qVar);
        return oVar;
    }
    
    public void mo16863b(FunnyCardNativeAd oVar) {
        super.mo16863b(oVar);
        Bitmap bitmap = oVar.mo16997c();
        Iterator it = this.linkedList.iterator();
        while (it.hasNext()) {
            ((C2248a) it.next()).mo16974a(bitmap);
        }
    }
}
