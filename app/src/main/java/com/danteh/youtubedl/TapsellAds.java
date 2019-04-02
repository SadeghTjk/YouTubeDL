package com.danteh.youtubedl;

import android.app.Application;

import ir.tapsell.sdk.Tapsell;

public class TapsellAds extends Application {
    @Override
    public void onCreate() {
        Tapsell.initialize(this, "578585");
        super.onCreate();
    }
}
