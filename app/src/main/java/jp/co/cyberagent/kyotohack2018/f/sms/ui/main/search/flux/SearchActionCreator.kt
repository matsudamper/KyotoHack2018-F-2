package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux

import android.annotation.SuppressLint
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.sms.repository.SearchRepository

class SearchActionCreator(
        private val searchDispatcher: SearchDispatcher,
        private val searchRepository: SearchRepository
) {

    @SuppressLint("CheckResult")
    fun loadCategories() {
        searchRepository.getCategories()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    searchDispatcher.dispatch(SearchAction.LoadCategories(it))
                }, {
                    it.printStackTrace()
                })
    }

    @SuppressLint("CheckResult")
    fun searchContents(categoryId: List<List<Long>>, page: Int = 100) {
        searchRepository.searchContents(categoryId, page)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    searchDispatcher.dispatch(SearchAction.SearchContents(it))
                }, {
                    it.printStackTrace()
                })
    }
}