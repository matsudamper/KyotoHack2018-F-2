package jp.co.cyberagent.kyotohack2018.f.sms.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivityMainBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActionCreator
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActionCreator: MainActionCreator by viewModel()

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.inflate<ActivityMainBinding>(LayoutInflater.from(this), R.layout.activity_main, null, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            mainActionCreator.navigateToHome(supportFragmentManager, isAddToBackStack = false)
        }

        binding.bottomNavigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home -> mainActionCreator.navigateToHome(supportFragmentManager)
                R.id.search -> mainActionCreator.navigateToSearch(supportFragmentManager)
                R.id.my_page -> mainActionCreator.navigateToMyPage(supportFragmentManager)
            }
        }
    }
}
