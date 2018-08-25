package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.item

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewContentSliderItemBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.loadUrl

data class ContentSliderItem(
        private val contentCard: ContentCard
) : BindableItem<ViewContentSliderItemBinding>() {

    override fun getLayout(): Int = R.layout.view_content_slider_item

    override fun bind(viewBinding: ViewContentSliderItemBinding, position: Int) {
        viewBinding.title.text = contentCard.title
        viewBinding.thumbnail.loadUrl(contentCard.thumbnail)
    }
}