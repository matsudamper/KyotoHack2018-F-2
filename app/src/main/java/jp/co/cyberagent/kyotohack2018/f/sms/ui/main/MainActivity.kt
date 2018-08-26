package jp.co.cyberagent.kyotohack2018.f.sms.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivityMainBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageStore
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityActionCreator: MainActivityActionCreator by inject()
    private val mainActivityStore: MainActivityStore by viewModel()


    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.inflate<ActivityMainBinding>(LayoutInflater.from(this), R.layout.activity_main, null, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mainActivityStore.changeBottom
                .doIfNull {
                    if (savedInstanceState == null) {
                        mainActivityActionCreator.changeFragment(supportFragmentManager,binding.toolBar, R.id.home, false)
                    }
                }
                .observeNotNull(this) {
                    mainActivityActionCreator.changeFragment(supportFragmentManager,binding.toolBar, it)
                }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            mainActivityActionCreator.changeBottom(it.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }
}
