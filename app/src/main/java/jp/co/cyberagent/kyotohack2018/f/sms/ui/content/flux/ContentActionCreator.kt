package jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux

import android.annotation.SuppressLint
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.sms.repository.ContentRepository

class ContentActionCreator(
        private val contentDispatcher: ContentDispatcher,
        private val contentRepository: ContentRepository
) {

    @SuppressLint("CheckResult")
    fun loadContent(id: Long) {
        contentRepository.getContent(id)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    contentDispatcher.dispatch(ContentAction.LoadContent(it))
                }, {

                })
    }
}