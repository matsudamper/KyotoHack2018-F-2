package jp.co.cyberagent.kyotohack2018.f.sms.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.model.PostArticle
import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivityMainBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.println
import jp.co.cyberagent.kyotohack2018.f.sms.repository.AuthRepository
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.ext.android.scopedWith
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.path.moduleName


class MainActivity : AppCompatActivity() {

    private val mainActivityActionCreator: MainActivityActionCreator by inject()
    private val mainActivityStore: MainActivityStore by viewModel()

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.inflate<ActivityMainBinding>(LayoutInflater.from(this), R.layout.activity_main, null, false)
    }

    val ser: SmsService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scopedWith(this::class.moduleName)
        setContentView(binding.root)

        // TODO 投稿部分を実データに置き換える
        val uuid: String = AuthRepository.uuid?: ""
        ser.createArticle(PostArticle(
                title = "つかれた",
                uid = uuid,
                thumbnail = "",
                description = "",
                contentId = 1,
                url = ""
        ))
                .subscribeOn(Schedulers.io())
                .subscribe({
                    "========つかれた".println()
                    it.println()
                }, {
                    it.message?.println()
                    "========aaaaaaa".println()
                    it.printStackTrace()
                })

        mainActivityStore.changeBottom
                .doIfNull {
                    savedInstanceState
                            ?: mainActivityActionCreator.changeFragment(supportFragmentManager, R.id.home)
                }
                .observeNotNull(this) {
                    mainActivityActionCreator.changeFragment(supportFragmentManager, it)
                }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            mainActivityActionCreator.changeBottom(it.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }
}
