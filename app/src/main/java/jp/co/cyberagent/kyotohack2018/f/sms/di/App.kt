package jp.co.cyberagent.kyotohack2018.f.sms.di

import android.app.Application
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.di.mainModule
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(applicationModule, mainModule))
    }
}