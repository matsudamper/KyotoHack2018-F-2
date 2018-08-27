package jp.co.cyberagent.kyotohack2018.f.sms.di

import jp.co.cyberagent.kyotohack2018.f.service.SmsMockService
import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.repository.CompanyRepository
import jp.co.cyberagent.kyotohack2018.f.sms.repository.EventRepository
import jp.co.cyberagent.kyotohack2018.f.sms.repository.HomeRepository
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.CompanyActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux.CompanyActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux.CompanyDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux.CompanyStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.EventActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux.EventActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux.EventDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux.EventStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.HomeFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.MypageFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageDispatvher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.SearchFragment
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.dsl.path.moduleName

val applicationModule = module {
    single { OkHttpClient.Builder().build() }
//    single {
//        val gson = GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
//                .create()
//
//        Retrofit.Builder()
//                .baseUrl(SmsService.BASE_URL)
//                .client(get())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build()
//                .create(SmsService::class.java)
//    }
    single { SmsMockService() } bind SmsService::class
    single { AppActionCreator() }
    factory { HomeRepository(get()) }
    factory { CompanyRepository(get()) }
    factory { EventRepository(get()) }

    single { MypageDispatvher() }
    single { MainActivityDispatcher() }
    single { CompanyDispatcher() }
    single { EventDispatcher() }
}

val mainActivityModule = module(MainActivity::class.moduleName) {
    // Fragment
    factory { HomeFragment() }
    factory { SearchFragment() }
    factory { MypageFragment() }

    // Flux
    factory { MainActivityActionCreator(get(), get()) }
    viewModel { MainActivityStore(get()) }

    factory { MypageActionCreator(get()) }
    viewModel { MypageStore(get()) }
}

val companyActivityModule = module(CompanyActivity::class.moduleName) {
    factory { CompanyActionCreator(get(), get()) }
    viewModel { CompanyStore(get()) }
}

val eventActivityModule = module(EventActivity::class.moduleName) {
    factory { EventActionCreator(get(), get()) }
    viewModel { EventStore(get()) }
}