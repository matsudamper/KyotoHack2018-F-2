package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.player.PlayerActivity
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.HomeFragment
import org.koin.standalone.KoinComponent
import org.koin.standalone.get

class MainActionCreator : ViewModel(), KoinComponent {

    private val containerId = R.id.container

    fun navigateToHome(manager: FragmentManager, isAddToBackStack: Boolean = true) {
        navigate(manager, get<HomeFragment>(), isAddToBackStack)
    }

    fun navigateToSearch(manager: FragmentManager) {
        navigate(manager, get<HomeFragment>())
    }

    fun navigateToMyPage(manager: FragmentManager) {
        navigate(manager, get<HomeFragment>())
    }

    private fun navigate(manager: FragmentManager, fragment: Fragment, isAddToBackStack: Boolean = true) {
        manager.beginTransaction()
                .replace(containerId, fragment)
                .apply { if (isAddToBackStack) addToBackStack(fragment::class.java.name) }
                .commitAllowingStateLoss()
    }

    fun openContent(context: Context?, content: Content) {
        context?.startActivity(PlayerActivity.createIntent(context, content))
    }
}
