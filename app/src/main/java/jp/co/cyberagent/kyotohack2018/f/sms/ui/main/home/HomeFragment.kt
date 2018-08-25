package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.co.cyberagent.kyotohack2018.f.model.HomeContent
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.FragmentHomeBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.item.HeaderSlider
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.SliderData
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.SliderHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val mainActivityStore: MainActivityStore by viewModel()
    private val mainActivityActionCreator: MainActivityActionCreator by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()), R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivityStore.loadHomeContent
                .observeNotNull(this) { setContent(it) }

        mainActivityActionCreator.loadHomeContent()
    }

    private fun setContent(homeContent: HomeContent) {
        binding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
            add(HeaderSlider(homeContent.banners))
            add(SliderHolder(
                    "新着",
                    homeContent.newContent.map { SliderData(it.title, it.thumbnail, it) },
                    { })
            )
            add(SliderHolder(
                    "ランキング",
                    homeContent.rankings.map { SliderData(it.title, it.thumbnail, it) },
                    { })
            )
            add(SliderHolder(
                    "履歴",
                    homeContent.histories.map { SliderData(it.title, it.thumbnail, it) },
                    { })
            )
        }
    }
}