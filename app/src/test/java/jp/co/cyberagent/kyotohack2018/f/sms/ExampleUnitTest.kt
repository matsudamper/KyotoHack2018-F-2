package jp.co.cyberagent.kyotohack2018.f.sms

import android.util.Log
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.service.sms.RetrofitServiceGenrator
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun dataFlowExample() {

        // HomeContentのとき
        RetrofitServiceGenrator.createSmsService()
                .getHomeContent()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { Log.d("TAG", it.message) }
                .doFinally { Log.d("TAG", "On Finally") }
                .subscribe { homeContent, t ->
                    Log.d("Tag", "$homeContent")
                    // TODO ここで何かしらの処理をする
                }


        RetrofitServiceGenrator.createSmsService()
                .getCategories()


    }
}
