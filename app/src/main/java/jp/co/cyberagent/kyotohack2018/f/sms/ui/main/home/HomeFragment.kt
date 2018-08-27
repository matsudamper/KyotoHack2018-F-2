package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home

import android.os.Bundle
import android.view.View
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.co.cyberagent.kyotohack2018.f.model.HomeContent
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.FragmentHomeBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainBaseFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.item.HeaderSlider
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.slider.SliderData
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.slider.SliderHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : MainBaseFragment<FragmentHomeBinding>() {
    override val titleResId: Int = R.string.fragment_home
    override val layoutResId: Int = R.layout.fragment_home
    override fun setTitle(layoutResId: Int) = binding.toolBar.setTitle(layoutResId)

    private val mainActivityStore: MainActivityStore by viewModel()
    private val mainActivityActionCreator: MainActivityActionCreator by inject()
    private val appActionCreator: AppActionCreator by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainActivityStore.loadHomeContent
                .doIfNull { mainActivityActionCreator.loadHomeContent() }
                .observeNotNull(this) {
                    setContent(it)
                }
    }

    private fun setContent(homeContent: HomeContent) {
        binding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
            add(HeaderSlider(homeContent.banners) {
                appActionCreator.openContent(this@HomeFragment.context, it)
            })
            add(SliderHolder(
                    "イベント", homeContent.events.map { SliderData(it.title, it.thumbnail, it) }) {
                appActionCreator.openEvent(this@HomeFragment.context, it)
            })
            add(SliderHolder(
                    "新着", homeContent.newContent.map { SliderData(it.title, it.thumbnail, it) }) {
                appActionCreator.openContent(this@HomeFragment.context, it)
            })
            add(SliderHolder(
                    "ランキング", homeContent.rankings.map { SliderData(it.title, it.thumbnail, it) }) {
                appActionCreator.openContent(this@HomeFragment.context, it)
            })
            add(SliderHolder(
                    "履歴", homeContent.histories.map { SliderData(it.title, it.thumbnail, it) }) {
                appActionCreator.openContent(this@HomeFragment.context, it)
            })
        }
    }
}