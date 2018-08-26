package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux

import android.annotation.SuppressLint
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.repository.MypageRepository
import org.koin.standalone.KoinComponent

class MypageActionCreator(
        private val mypageRepository: MypageRepository,
        private val mainActivityDispatcher: MypageDispatvher
) : KoinComponent {

    private val containerId = R.id.container

    @SuppressLint("CheckResult")
    fun loadMyself() {
        mypageRepository.getMyself()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mainActivityDispatcher.dispatch(MypageAction.LoadMyself(it))
                }, {

                })
    }
}
