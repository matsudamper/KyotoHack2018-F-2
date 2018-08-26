package jp.co.cyberagent.kyotohack2018.f.service

import io.reactivex.Flowable
import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.model.HomeContent
import jp.co.cyberagent.kyotohack2018.f.model.Myself
import jp.co.cyberagent.kyotohack2018.f.model.category.RootCategory
import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.model.event.Event
import retrofit2.http.GET
import retrofit2.http.Query

interface SmsService {

    companion object {
        const val BASE_URL = "https://f-api.kyotohack.com"
    }

    @GET("/home_content")
    fun getHomeContent(): Flowable<HomeContent>

    @GET("/categories")
    fun getCategories(): Flowable<List<RootCategory>>

    @GET("/content_article")
    fun getContentArticle(page: Long = 0): Flowable<List<Article>>

    @GET("/my_user_info")
    fun getMyUser(): Flowable<Myself>

    @GET("/content")
    fun getContent(@Query("id") id: Long): Flowable<Content>

    @GET("/company")
    fun getCompany(@Query("id") id: Long): Flowable<Company>

    @GET("/event")
    fun getEvent(@Query("id") id: Long): Flowable<Event>

    @GET("/search")
    fun searchContentCard(categoryId: List<List<Long>>, page: Int): Flowable<List<ContentCard>>
}