package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMappedLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class MainActivityStore(
        mainActivityDispatcher: MainActivityDispatcher
) : Store() {

    val changeBottom = mainActivityDispatcher.onBottomChange.toMappedLiveData()
    val loadHomeContent = mainActivityDispatcher.onLoadHomeContent.toMappedLiveData()
    val loadMyself = mainActivityDispatcher.onLoadMyself.toMappedLiveData()
}
