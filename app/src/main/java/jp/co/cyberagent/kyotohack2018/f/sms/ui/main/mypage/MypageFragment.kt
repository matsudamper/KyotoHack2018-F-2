package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage

import android.os.Bundle
import android.view.View
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.co.cyberagent.kyotohack2018.f.model.Myself
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.FragmentMypageBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainBaseFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.item.MypageHeaderItem
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.slider.SliderData
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.slider.SliderHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MypageFragment : MainBaseFragment<FragmentMypageBinding>() {

    override val titleResId: Int = R.string.fragment_mypage
    override val layoutResId: Int = R.layout.fragment_mypage
    override fun setTitle(layoutResId: Int) = binding.toolBar.setTitle(layoutResId)

    private val mainActivityActionCreator: MainActivityActionCreator by inject()
    private val mainActivityStore: MainActivityStore by viewModel()

    private val mypageActionCreator: MypageActionCreator by inject()
    private val mypageStore: MypageStore by viewModel()

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