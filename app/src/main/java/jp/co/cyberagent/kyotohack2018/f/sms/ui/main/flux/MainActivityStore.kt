package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMappedLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageDispatvher
import org.koin.standalone.KoinComponent

class MainActivityStore(
        mainActivityDispatcher: MainActivityDispatcher
) : Store(), KoinComponent {

    val changeBottom = mainActivityDispatcher.onBottomChange.toMappedLiveData()
    val loadHomeContent = mainActivityDispatcher.onLoadHomeContent.toMappedLiveData()
    val loadMyself = mainActivityDispatcher.onLoadMyself.toMappedLiveData()
}
