package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
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

        Toast.makeText(requireContext(), "sarch", Toast.LENGTH_SHORT).show()
    }

    private fun setContent(homeContent: HomeContent) {
//        binding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
//            add(HeaderSlider(homeContent.banners))
//        }
    }
}