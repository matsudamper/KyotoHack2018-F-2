package jp.co.cyberagent.kyotohack2018.f.service

import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.model.Category
import jp.co.cyberagent.kyotohack2018.f.model.HomeContent
import jp.co.cyberagent.kyotohack2018.f.model.User
import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import retrofit2.http.GET
import retrofit2.http.Query

interface SmsService {

    @GET("home_content")
    fun getHomeContent(): HomeContent

    @GET("categories")
    fun getCategories(): List<Category>

    @GET("content_article")
    fun getContentArticle(page: Long = 0): List<Article>

    @GET("my_user_info")
    fun getMyUser(): User

    @GET("content")
    fun getContent(@Query("id") id: Long): Content

    @GET("company")
    fun getCompany(@Query("id") id: Long): Company

    @GET("search")
    fun searchContent(categoryId: List<List<Long>>, page: Int): List<Content>
}