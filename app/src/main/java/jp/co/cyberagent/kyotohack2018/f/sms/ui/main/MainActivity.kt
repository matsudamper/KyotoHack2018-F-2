package jp.co.cyberagent.kyotohack2018.f.sms.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.service.sms.RetrofitServiceGenrator
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivityMainBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scopedWith(this::class.moduleName)
        setContentView(binding.root)

        mainActivityStore.changeBottom
                .doIfNull {
                    if (savedInstanceState == null) {
                        mainActivityActionCreator.changeFragment(supportFragmentManager, R.id.home, false)
                    }
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
