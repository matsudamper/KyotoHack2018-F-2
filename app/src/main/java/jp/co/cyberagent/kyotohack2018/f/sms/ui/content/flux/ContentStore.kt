package jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMapLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class ContentStore(
        contentDispatcher: ContentDispatcher
) : Store() {

    val content = contentDispatcher.onLoadContent.toMapLiveData()
}