package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMappedLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MainActivityStore : Store(), KoinComponent {
    private val mainActivityDispatcher: MainActivityDispatcher by inject()

    val changeBottom = mainActivityDispatcher.onBottomChange.toMappedLiveData()
}
