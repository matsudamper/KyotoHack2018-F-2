package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.model.PostArticle
import jp.co.cyberagent.kyotohack2018.f.service.SmsService

class ArticleRepository(
        private val smsService: SmsService
) {
    fun getArticles(id : Long) = smsService.getContentArticle(id)

    fun sendArticle(data : PostArticle) = smsService.createArticle(data)
}