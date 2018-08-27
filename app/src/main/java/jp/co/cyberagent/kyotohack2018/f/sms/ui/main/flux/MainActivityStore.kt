package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMapLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class MainActivityStore(
        mainActivityDispatcher: MainActivityDispatcher
) : Store() {

    val changeBottom = mainActivityDispatcher.onBottomChange.toMapLiveData()
    val loadHomeContent = mainActivityDispatcher.onLoadHomeContent.toMapLiveData()
    val loadMyself = mainActivityDispatcher.onLoadMyself.toMapLiveData()
}
