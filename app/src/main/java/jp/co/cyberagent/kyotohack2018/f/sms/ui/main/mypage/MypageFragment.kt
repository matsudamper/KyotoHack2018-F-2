package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.co.cyberagent.kyotohack2018.f.model.Myself
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewRecyclerBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.item.MypageHeaderItem
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.slider.SliderData
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.slider.SliderHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MypageFragment : Fragment() {

    private val mainActivityActionCreator: MainActivityActionCreator by inject()
    private val mainActivityStore: MainActivityStore by viewModel()

    private val mypageActionCreator: MypageActionCreator by inject()
    private val mypageStore: MypageStore by viewModel()

    lateinit var binding: ViewRecyclerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()), R.layout.view_recycler, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isLogined = true


        if (isLogined.not()) {
            // TODO LGIN
        } else {

        }

        mainActivityStore.loadMyself
                .doIfNull { mainActivityActionCreator.loadMyself() }
                .observeNotNull(this) { createView(it) }
    }

    fun createView(myself: Myself) {
        val adapter = GroupAdapter<ViewHolder>().apply {
            add(MypageHeaderItem({

            }))
            add(SliderHolder("履歴",
                    myself.posts.map { SliderData(it.title, it.thumbnail, it) }) {

            })
        }

        binding.recyclerView.swapAdapter(adapter, false)
    }
}