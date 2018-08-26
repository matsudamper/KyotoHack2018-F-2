package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMappedLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store
import org.koin.standalone.KoinComponent

class MypageStore(
        mypageDispatcher: MypageDispatvher
) : Store(), KoinComponent {

    val loadMyself = mypageDispatcher.onLoadMyself.toMappedLiveData()
}
