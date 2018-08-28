package jp.co.cyberagent.kyotohack2018.f.service

import com.google.gson.JsonObject
import io.reactivex.Flowable
import io.reactivex.Single
import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.model.HomeContent
import jp.co.cyberagent.kyotohack2018.f.model.Myself
import jp.co.cyberagent.kyotohack2018.f.model.category.Category
import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.model.event.Event
import jp.co.cyberagent.kyotohack2018.f.service.sms.RegistUser
import retrofit2.http.*

interface SmsService {

    companion object {
        const val BASE_URL = "https://f-api.kyotohack.com/"
    }

    @GET("/api/v1/home_content")
    fun getHomeContent(): Single<HomeContent>

    @GET("/api/v1/categories")
    fun getCategories(): Single<Map<String, List<Category>>>

    @GET("/api/v1/content/{contentId}/articles/")
    fun getContentArticle(@Path("contentId") id: Long): Flowable<List<Article>>

//    @GET("/api/v1/contents/search")
//    fun searchContents(categoryId: List<@JvmSuppressWildcards List<@JvmSuppressWildcards Long>>, page: Int): Single<@JvmSuppressWildcards List<@JvmSuppressWildcards ContentCard>>

    @GET("/api/v1/categories/contents")
    fun searchContents(@Query("platforms") platformIds: String, @Query("languages") languageIds: String): Single<List<ContentCard>>

    @GET("/api/v1/content/{companyId}")
    fun getContent(@Path("companyId") id: Long): Single<Content>

    @GET("/api/v1/company/{companyId}")
    fun getCompany(@Path("companyId") id: Long): Single<Company>

    @GET("/api/v1/event/{eventId}")
    fun getEvent(@Path("eventId") id: Long): Single<Event>

    @GET("/my_user_info")
    fun getMyself(): Flowable<Myself>

    @Headers("Accept: application/json",
            "Content-Type: application/json")
    @POST("/api/v1/user")
    fun createUser(@Body user: RegistUser): Single<RegistUser>

    @GET("/api/v1/user/{uid}/articles")
    fun getArticlesByUID(@Path("uid") uid: String): Single<List<Article>>

    @Headers("Accept: application/json",
            "Content-Type: application/json")
    @POST("/api/v1/article")
    fun createArticle(@Body body: Article): Single<Article>

    @Headers("Accept: application/json",
            "Content-Type: application/json")
    @POST("/api/v1/browsedHistory")
    fun createBrowsedHistory(@Body json: JsonObject): Single<JsonObject>

}