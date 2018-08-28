package jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.flux

import androidx.lifecycle.toLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class ArticleStore(
        articleDispatcher: ArticleDispatcher
) : Store(){

    val article = articleDispatcher.onArticles.toLiveData()
}