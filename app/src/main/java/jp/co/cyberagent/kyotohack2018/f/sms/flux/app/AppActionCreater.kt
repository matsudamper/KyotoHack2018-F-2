package jp.co.cyberagent.kyotohack2018.f.sms.flux.app

import android.content.Context
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.player.PlayerActivity

class AppActionCreater {

    fun openContent(context: Context?, content: Content) {
        context?.startActivity(PlayerActivity.createIntent(context, content))
    }
}