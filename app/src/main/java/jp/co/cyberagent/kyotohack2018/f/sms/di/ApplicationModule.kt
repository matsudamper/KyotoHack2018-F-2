package jp.co.cyberagent.kyotohack2018.f.sms.di

import com.google.firebase.auth.FirebaseAuth
import jp.co.cyberagent.kyotohack2018.f.service.sms.RetrofitServiceGenerator
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.repository.*
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.CompanyActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux.CompanyActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux.CompanyDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux.CompanyStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.ContentActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux.ContentActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux.ContentDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux.ContentStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.EventActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux.EventActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux.EventDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux.EventStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.HomeFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.LoginFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.MypageFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageDispatvher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.SearchFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux.SearchActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux.SearchDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux.SearchStore
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.dsl.path.moduleName

val applicationModule = module {
    single { OkHttpClient.Builder().build() }
    single { RetrofitServiceGenerator.createSmsService() }
    single { AppActionCreator() }
    factory { HomeRepository(get()) }
    factory { CompanyRepository(get()) }
    factory { EventRepository(get()) }
    factory { ContentRepository(get()) }
    factory { SearchRepository(get()) }

    single { MypageDispatvher() }
    single { MainActivityDispatcher() }
    single { CompanyDispatcher() }
    single { EventDispatcher() }
    single { ContentDispatcher() }
    single { SearchDispatcher() }
}

val mainActivityModule = module(MainActivity::class.moduleName) {
    // Fragment
    factory { HomeFragment() }
    factory { SearchFragment() }
    factory { MypageFragment() }
    factory { LoginFragment() }

    // Flux
    factory { MainActivityActionCreator(get(), get()) }
    viewModel { MainActivityStore(get()) }

    factory { MypageActionCreator(get()) }
    viewModel { MypageStore(get()) }

    factory { SearchActionCreator(get(), get()) }
    viewModel { SearchStore(get()) }

    single { FirebaseAuth.getInstance() }
}

val companyActivityModule = module(CompanyActivity::class.moduleName) {
    factory { CompanyActionCreator(get(), get()) }
    viewModel { CompanyStore(get()) }
}

val eventActivityModule = module(EventActivity::class.moduleName) {
    factory { EventActionCreator(get(), get()) }
    viewModel { EventStore(get()) }
}

val contentActivityModule = module(ContentActivity::class.moduleName) {
    factory { ContentActionCreator(get(), get()) }
    viewModel { ContentStore(get()) }
}