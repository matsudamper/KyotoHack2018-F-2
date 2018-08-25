package jp.co.cyberagent.kyotohack2018.f.model.content

import jp.co.cyberagent.kyotohack2018.f.model.category.Category
import jp.co.cyberagent.kyotohack2018.f.model.company.CompanyCard

interface BaseContent {
    val id: Long
    val company: CompanyCard
    val author: String
    val categories: List<Category>
    val title: String
    val description: String
    val thumbnail: String
    val isBookMarked: Boolean
    val createAt: Long
}