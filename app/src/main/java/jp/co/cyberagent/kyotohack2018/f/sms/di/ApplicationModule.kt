package jp.co.cyberagent.kyotohack2018.f.sms.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import jp.co.cyberagent.kyotohack2018.f.service.SmsMockService
import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import jp.co.cyberagent.kyotohack2018.f.sms.repository.HomeRepository
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.HomeFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.SarchFragment
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val applicationModule = module {
    single { OkHttpClient.Builder().build() }
    single {
        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create()

        Retrofit.Builder()
                .baseUrl(SmsService.BASE_URL)
                .client(get())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(SmsService::class.java)
    }
    single { SmsMockService() }
    factory { HomeRepository() }
}

val scopedModule = module {
    // Fragment
    single { HomeFragment() }
    single { SarchFragment() }

    // Flux
    factory { MainActivityActionCreator(get(), get()) }
    single { MainActivityDispatcher() }
    viewModel { MainActivityStore(get()) }
}
