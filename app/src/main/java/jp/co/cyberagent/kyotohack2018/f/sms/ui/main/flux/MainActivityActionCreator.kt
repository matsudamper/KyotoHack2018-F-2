package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.HomeFragment
import org.koin.standalone.KoinComponent
import org.koin.standalone.get
import org.koin.standalone.inject

class MainActivityActionCreator : KoinComponent {

    private val containerId = R.id.container

    private val mainActivityDispatcher: MainActivityDispatcher by inject()

    fun changeBottom(position: Int) {
        mainActivityDispatcher.dispatch(MainActivityAction.ChangeBottom(position))
    }

    fun changeFragment(manager: FragmentManager, @IdRes itemId: Int, isAddToBackStack: Boolean = true) {
        when (itemId) {
            R.id.home -> navigate(manager, get<HomeFragment>(), isAddToBackStack)
            R.id.search -> navigate(manager, get<HomeFragment>())
            R.id.my_page -> navigate(manager, get<HomeFragment>())
        }
    }

    private fun navigate(manager: FragmentManager, fragment: Fragment, isAddToBackStack: Boolean = true) {
        manager.beginTransaction()
                .replace(containerId, fragment)
                .apply { if (isAddToBackStack) addToBackStack(fragment::class.java.name) }
                .commitAllowingStateLoss()
    }
}
