package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.service.SmsService

class SearchRepository(
        private val smsService: SmsService
) {

    fun getCategories() = smsService.getCategories()

    fun searchContents(categoryId: List<List<Long>>, page: Int) = smsService.searchContents(categoryId, page)
}