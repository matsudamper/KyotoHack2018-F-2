package jp.co.cyberagent.kyotohack2018.f.sms.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivityMainBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
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
                .observeNotNull(this) {
                    mainActivityActionCreator.changeFragment(supportFragmentManager, it)
                }

        binding.bottomNavigationView.setOnNavigationItemReselectedListener {
            val index = when (it.itemId) {
                R.id.home -> 0
                R.id.search -> 1
                R.id.my_page -> 2
                else -> throw IllegalStateException()
            }
            mainActivityActionCreator.changeBottom(index)
        }

        mainActivityActionCreator.changeFragment(
                supportFragmentManager,
                MainActivityFragments.HOME,
                isAddToBackStack = false
        )
    }
}
