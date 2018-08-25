package jp.co.cyberagent.kyotohack2018.f.sms.ui.view

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewContentSliderItemBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.loadUrl

data class SliderItem<T>(
        private val sliderItem: SliderData<T>,
        private val onClickListener: ((T) -> Unit)
) : BindableItem<ViewContentSliderItemBinding>() {

    override fun getLayout(): Int = R.layout.view_content_slider_item

    override fun bind(viewBinding: ViewContentSliderItemBinding, position: Int) {
        viewBinding.title.text = sliderItem.title
        viewBinding.thumbnail.loadUrl(sliderItem.thumbnail)
        viewBinding.root.setOnClickListener {
            onClickListener(sliderItem.item)
        }
    }
}