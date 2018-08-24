package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.di

import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.HomeFragment
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val mainModule = module {
    viewModel { MainActionCreator() }
    single { HomeFragment() }
}