package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.item

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewHeaderSliderBinding

class HeaderSlider(

) : BindableItem<ViewHeaderSliderBinding>() {

    override fun getLayout() = R.layout.view_header_slider

    override fun bind(viewHolder: ViewHeaderSliderBinding, p1: Int) {
        viewHolder.recyclerView
    }
}