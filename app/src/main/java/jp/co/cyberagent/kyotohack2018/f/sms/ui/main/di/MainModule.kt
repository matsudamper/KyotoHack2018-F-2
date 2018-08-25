package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.di

import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityDispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.HomeFragment
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.dsl.path.moduleName

val mainModule = module(MainActivity::class.moduleName) {
    single { MainActivityActionCreator() }
    single { MainActivityDispatcher() }
    viewModel { MainActivityStore() }

    single { HomeFragment() }
}