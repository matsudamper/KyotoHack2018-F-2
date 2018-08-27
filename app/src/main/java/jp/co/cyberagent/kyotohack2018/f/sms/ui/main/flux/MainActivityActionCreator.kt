package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import android.annotation.SuppressLint
import androidx.annotation.IdRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.repository.HomeRepository
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.HomeFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.MypageFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.SearchFragment
import org.koin.standalone.KoinComponent
import org.koin.standalone.get

class MainActivityActionCreator(
        private val homeRepository: HomeRepository,
        private val mainActivityDispatcher: MainActivityDispatcher
) : KoinComponent {

    var hoge = 0

    private val containerId = R.id.container

    fun changeBottom(position: Int) {
        mainActivityDispatcher.dispatch(MainActivityAction.ChangeBottom(position))
    }

    fun changeFragment(manager: FragmentManager,@IdRes itemId: Int, isAddToBackStack: Boolean = true) {

        when (itemId) {
            R.id.home -> navigate(manager, get<HomeFragment>(), isAddToBackStack)
            R.id.search -> navigate(manager, get<SearchFragment>())
            R.id.my_page -> navigate(manager, get<MypageFragment>())
            else -> throw IllegalStateException()
        }
    }

    private fun navigate(manager: FragmentManager, fragment: Fragment, isAddToBackStack: Boolean = true) {
        manager.beginTransaction()
                .replace(containerId, fragment)
                .apply { if (isAddToBackStack) addToBackStack(fragment::class.java.name) }
                .commitAllowingStateLoss()
    }

    @SuppressLint("CheckResult")
    fun loadHomeContent() {
        homeRepository.getHomeContent()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mainActivityDispatcher.dispatch(MainActivityAction.LoadHomeContent(it))
                }, {
                    it.printStackTrace()
                })
    }

    @SuppressLint("CheckResult")
    fun loadMyself() {
        homeRepository.getMyself()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mainActivityDispatcher.dispatch(MainActivityAction.LoadMyself(it))
                }, {

                })
    }
}
