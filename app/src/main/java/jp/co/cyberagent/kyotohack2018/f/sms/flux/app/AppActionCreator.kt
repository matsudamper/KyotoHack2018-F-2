package jp.co.cyberagent.kyotohack2018.f.sms.flux.app

import android.content.Context
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.model.event.EventCard
import jp.co.cyberagent.kyotohack2018.f.player.PlayerActivity

class AppActionCreator {

    fun openContent(context: Context?, content: ContentCard) {
        context?.startActivity(PlayerActivity.createIntent(context, content))
    }

    fun openEvent(context: Context?, content: EventCard) {

    }
}