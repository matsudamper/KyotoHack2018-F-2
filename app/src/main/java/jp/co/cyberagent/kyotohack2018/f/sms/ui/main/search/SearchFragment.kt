package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import jp.co.cyberagent.kyotohack2018.f.model.HomeContent
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.FragmentSearchBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainBaseFragment

class SearchFragment : MainBaseFragment<FragmentSearchBinding>() {
    override val titleResId = R.string.fragment_search
    override val layoutResId = R.layout.fragment_search
    override fun setTitle(layoutResId: Int) = binding.toolBar.setTitle(layoutResId)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun setContent(homeContent: HomeContent) {
//        binding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
//            add(HeaderSlider(homeContent.banners))
//        }
    }
}