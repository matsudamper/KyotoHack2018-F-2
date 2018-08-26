package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMappedLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store
import org.koin.standalone.KoinComponent

class MainActivityStore(
        private val mainActivityDispatcher: MainActivityDispatcher
) : Store(), KoinComponent {

    val changeBottom = mainActivityDispatcher.onBottomChange.toMappedLiveData()
    val loadHomeContent = mainActivityDispatcher.onLoadHomeContent.toMappedLiveData()
}
