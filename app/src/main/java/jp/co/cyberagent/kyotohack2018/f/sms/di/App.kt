package jp.co.cyberagent.kyotohack2018.f.sms.di

import android.app.Application
import com.chibatching.kotpref.Kotpref
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                applicationModule,
                mainActivityModule,
                companyActivityModule,
                eventActivityModule,
                contentActivityModule,
                articleActivityModule
        ))

        Kotpref.init(this)
    }
}