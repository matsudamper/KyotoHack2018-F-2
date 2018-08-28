package jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux

import android.annotation.SuppressLint
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.model.BrowsedHistory
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.repository.ContentRepository

class ContentActionCreator(
        private val appActionCreator: AppActionCreator,
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
                    appActionCreator.displayError(it)
                })
    }

    @SuppressLint("CheckResult")
    fun sendHistory(id: Long, uuid: String) {
        contentRepository.sendHistory(BrowsedHistory(uuid, id))
                .subscribeOn(Schedulers.io())
                .subscribe({
                    contentDispatcher.dispatch(ContentAction.SendHistory(it))
                }, {
                    appActionCreator.displayError(it)
                })
    }
}