package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainActivityFragments
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

    fun changeFragment(manager: FragmentManager, position: Int, isAddToBackStack: Boolean = true) {
        when (position) {
            MainActivityFragments.HOME -> navigate(manager, get<HomeFragment>(), isAddToBackStack)
            MainActivityFragments.SEARCH -> navigate(manager, get<HomeFragment>())
            MainActivityFragments.MYPAGE -> navigate(manager, get<HomeFragment>())
        }
    }

    private fun navigate(manager: FragmentManager, fragment: Fragment, isAddToBackStack: Boolean = true) {
        manager.beginTransaction()
                .replace(containerId, fragment)
                .apply { if (isAddToBackStack) addToBackStack(fragment::class.java.name) }
                .commitAllowingStateLoss()
    }
}
