package com.example.zimkitdemo

import android.app.Application
import com.zegocloud.zimkit.services.ZIMKit
import com.zegocloud.zimkit.services.ZIMKitConfig

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        sInstance = this

        val zimKitConfig = ZIMKitConfig()

        ZIMKit.initWith(this, BuildConfig.APP_ID.toLong(), BuildConfig.APP_SIGN, zimKitConfig)
        ZIMKit.initNotifications()
    }

    companion object {
        var sInstance: MyApplication? = null
    }
}
