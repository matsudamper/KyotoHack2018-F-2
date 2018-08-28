package jp.co.cyberagent.kyotohack2018.f.sms.repository

import android.util.Log
import jp.co.cyberagent.kyotohack2018.f.service.SmsService

class SearchRepository(
        private val smsService: SmsService
) {

    fun getCategories() = smsService.getCategories()

    fun searchContents(categoryId: List<List<Long>>, page: Int) = smsService.searchContents(categoryId[0].toParamType(), categoryId[1].toParamType())

    // ListをInterface側といい感じに合わせるための関数
    // TODO ここにあるのはおかしいと思うんで出来れば直す
    private fun List<Long>.toParamType(): String = this.joinToString("-")
}
