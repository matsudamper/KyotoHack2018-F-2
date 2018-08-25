package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.item

import android.graphics.Color
import android.net.Uri
import android.util.Log
import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewHeaderSliderItemBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.loadUrl

class HeaderSliderItem(
        val header: ContentCard
) : BindableItem<ViewHeaderSliderItemBinding>() {

    override fun getLayout() = R.layout.view_header_slider_item

    override fun bind(viewHolder: ViewHeaderSliderItemBinding, p1: Int) {
        viewHolder.imageView.setBackgroundColor(Color.YELLOW)
        viewHolder.imageView.loadUrl(header.thumbnail)
    }
}