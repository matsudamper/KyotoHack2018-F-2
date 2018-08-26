package jp.co.cyberagent.kyotohack2018.f.service.sms

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitServiceGenrator {

    private fun createRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getClient())
//            .client(getUnsafeClient())
            .addConverterFactory(createGson())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private fun createApiRetrofit(): Retrofit =
            createRetrofit("")

    // Gsonのインスタンス化
    private fun createGson(): GsonConverterFactory {
        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        return GsonConverterFactory.create(gson)
    }

    // OkHttp3のクライアントを作成
    private fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
    }

}