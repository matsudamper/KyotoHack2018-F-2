package jp.co.cyberagent.kyotohack2018.f.sms.ui.content.item

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewPlayDescriptionBinding


class PlayDescriptionItem(
        private val text: String
) : BindableItem<ViewPlayDescriptionBinding>() {
    override fun getLayout() = R.layout.view_play_description

    override fun bind(viewHolder: ViewPlayDescriptionBinding, p1: Int) {
        viewHolder.description.text = text
    }
}