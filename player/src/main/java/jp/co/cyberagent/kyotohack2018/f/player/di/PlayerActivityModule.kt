package jp.co.cyberagent.kyotohack2018.f.player.di

import jp.co.cyberagent.kyotohack2018.f.player.PlayerActivity
import org.koin.dsl.module.module
import org.koin.dsl.path.moduleName

class PlayerActivityModule {
    companion object {
        val module = module(PlayerActivity::class.moduleName) {

        }
    }
}
