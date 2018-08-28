package jp.co.cyberagent.kyotohack2018.f.sms.di

import com.google.firebase.auth.FirebaseAuth
import jp.co.cyberagent.kyotohack2018.f.service.sms.RetrofitServiceGenerator
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.repository.*
import jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.ArticleActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.flux.ArticleActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.flux.ArticleDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.flux.ArticleStore
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
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.flux.LoginActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.flux.LoginDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.flux.LoginStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.MypageFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageDispatvher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.SearchFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux.SearchActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux.SearchDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux.SearchStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.post.PostActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.post.flux.PostActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.post.flux.PostDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.post.flux.PostStore
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
    factory { LoginRepository(get()) }
    factory { ArticleRepository(get()) }

    single { MypageDispatvher() }
    single { MainActivityDispatcher() }
    single { CompanyDispatcher() }
    single { EventDispatcher() }
    single { ContentDispatcher() }
    single { SearchDispatcher() }
    single { LoginDispatcher() }
    single { ArticleDispatcher() }
    single { PostDispatcher() }
}

val mainActivityModule = module(MainActivity::class.moduleName) {
    // Fragment
    factory { HomeFragment() }
    factory { SearchFragment() }
    factory { MypageFragment() }
    factory { LoginFragment() }

    // Flux
    factory { MainActivityActionCreator(get(), get(), get()) }
    viewModel { MainActivityStore(get()) }

    factory { MypageActionCreator(get()) }
    viewModel { MypageStore(get()) }

    factory { SearchActionCreator(get(), get(), get()) }
    viewModel { SearchStore(get()) }

    single { FirebaseAuth.getInstance() }

    factory { LoginActionCreator(get(), get(), get()) }
    viewModel { LoginStore(get()) }
}

val companyActivityModule = module(CompanyActivity::class.moduleName) {
    factory { CompanyActionCreator(get(), get(), get()) }
    viewModel { CompanyStore(get()) }
}

val eventActivityModule = module(EventActivity::class.moduleName) {
    factory { EventActionCreator(get(), get(), get()) }
    viewModel { EventStore(get()) }
}

val contentActivityModule = module(ContentActivity::class.moduleName) {
    factory { ContentActionCreator(get(), get(), get()) }
    viewModel { ContentStore(get()) }
}

val articleActivityModule = module(ArticleActivity::class.moduleName) {
    factory { ArticleActionCreator(get(), get(), get()) }
    viewModel { ArticleStore(get()) }
}

val postActivityModule = module(PostActivity::class.moduleName) {
    factory { PostActionCreator(get(), get(), get()) }
    viewModel { PostStore(get()) }
}