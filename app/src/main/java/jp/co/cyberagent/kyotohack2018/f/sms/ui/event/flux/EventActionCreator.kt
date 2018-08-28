package jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux

import android.annotation.SuppressLint
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.sms.ext.println
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.repository.EventRepository

class EventActionCreator(
        private val appActionCreator: AppActionCreator ,
        private val eventDispatcher: EventDispatcher,
        private val eventRepository: EventRepository
) {

    @SuppressLint("CheckResult")
    fun loadEvent(id: Long) {
        eventRepository.getEvent(id)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    it.println()
                    eventDispatcher.dispatch(EventAction.LoadEvent(it))
                }, {
                    appActionCreator.displayError(it)
                })
    }
}