package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMapLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class SearchStore(
        searchDispatcher: SearchDispatcher
) : Store() {

    val categories = searchDispatcher.onLoadCatogories.toMapLiveData()
    val searchContents = searchDispatcher.onSearchContents.toMapLiveData()
}