package jp.co.cyberagent.kyotohack2018.f.sms.ui.content.di

import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.ContentActivity
import org.koin.dsl.module.module
import org.koin.dsl.path.moduleName

class PlayerActivityModule {
    companion object {
        val module = module(ContentActivity::class.moduleName) {

        }
    }
}
