package jp.co.cyberagent.kyotohack2018.f.service.sms

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitServiceGenerator {

    private fun createRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getClient())
            .addConverterFactory(createGson())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private fun createSmsRetrofit(): Retrofit = createRetrofit(SmsService.BASE_URL)

    // 呼び出し対象のAPIをインスタンス化
    fun createSmsService(): SmsService = createSmsRetrofit().create(SmsService::class.java)
    
    // Gsonのインスタンス化
    private fun createGson() =
            GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()
                    .let { GsonConverterFactory.create(it) }

    // OkHttp3のクライアントを作成
    private fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
    }
}