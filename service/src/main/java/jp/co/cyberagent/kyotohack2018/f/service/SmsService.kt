package jp.co.cyberagent.kyotohack2018.f.service

import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.model.Category
import jp.co.cyberagent.kyotohack2018.f.model.HomeContent
import jp.co.cyberagent.kyotohack2018.f.model.User
import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import jp.co.cyberagent.kyotohack2018.f.model.content.Content

interface SmsService {

    fun getHomeContent(): HomeContent

    fun getCategories(): List<Category>

    fun getContentArticle(currentPage: Long): List<Article>

    fun getMyUser(): User

    // 全部の情報が欲しい時
    fun getContent(id: Long): Content

    fun getCompany(id: Long): Company

    // 検索系
    fun searchContent(categoryId: List<Long>): List<Content>
}