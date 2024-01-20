package com.abhishek.xplayer.ad;

import android.content.Context;
import android.util.Log;

import java.util.Iterator;
import java.util.LinkedList;


public class FolderListNativeAd extends AppAbstractAds<FolderListNativeAdLoader> {

    
    private static FolderListNativeAd folderListNativeAd;

    
    private FolderListNativeAdLoader folderListNativeAsLoader;

    
    private LinkedList<AppAbstractInterface<FolderListNativeAdLoader>> linkedList = new LinkedList<>();

  
    public String mo16910a() {
        return "FolderList";
    }

    
    public static FolderListNativeAd createRefrence() {
        if (folderListNativeAd == null) {
            folderListNativeAd = new FolderListNativeAd();
        }
        return folderListNativeAd;
    }

    private FolderListNativeAd() {
    }

   
    public FolderListNativeAdLoader mo16909a(Context context, AppAbstractInterface<FolderListNativeAdLoader> qVar) {
        Log.e("folderListAds","adload unkwon");
        FolderListNativeAdLoader iVar = new FolderListNativeAdLoader(context);
        iVar.mo16951a(qVar);
        return iVar;
    }

    public void mo16863b(FolderListNativeAdLoader iVar) {
        super.mo16863b(iVar);
        FolderListNativeAdLoader iVar2 = this.folderListNativeAsLoader;
        if (iVar2 != null) {
            iVar2.mo16952c();
        }
        this.folderListNativeAsLoader = iVar;
        Iterator it = this.linkedList.iterator();
        while (it.hasNext()) {
            ((AppAbstractInterface) it.next()).mo16863b(iVar);
        }
    }

    public void mo16860a(FolderListNativeAdLoader iVar) {
        super.mo16860a(iVar);
        Iterator it = this.linkedList.iterator();
        while (it.hasNext()) {
            ((AppAbstractInterface) it.next()).mo16860a(iVar);
        }
    }

    
    public boolean mo16917d() {
        return super.mo16917d() || this.folderListNativeAsLoader != null;
    }

    
    public FolderListNativeAdLoader mo16960f() {
        if (folderListNativeAsLoader != null && folderListNativeAsLoader.mo16906e()) {
            Log.e("folderListAds","adload 1");
            this.folderListNativeAsLoader.mo16952c();
            this.folderListNativeAsLoader = null;
        }
        return this.folderListNativeAsLoader;
    }

    
    public void mo16959c(FolderListNativeAdLoader iVar) {
        if (this.f7944a == iVar) {
            this.f7944a = null;
        }
    }

    
    public void mo16955a(AppAbstractInterface<FolderListNativeAdLoader> qVar) {
        this.linkedList.add(qVar);
    }

    
    public void mo16958b(AppAbstractInterface<FolderListNativeAdLoader> qVar) {
        this.linkedList.remove(qVar);
    }
}
