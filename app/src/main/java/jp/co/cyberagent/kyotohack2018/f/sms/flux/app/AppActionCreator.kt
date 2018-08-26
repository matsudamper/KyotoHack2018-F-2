package jp.co.cyberagent.kyotohack2018.f.sms.flux.app

import android.content.Context
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.model.event.EventCard
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.ContentActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.EventActivity

class AppActionCreator {

    fun openContent(context: Context?, content: ContentCard) {
        context?.startActivity(ContentActivity.createIntent(context, content))
    }

    fun openEvent(context: Context?, eventCard: EventCard) {
        context?.startActivity(EventActivity.createIntent(context, eventCard))
    }
}