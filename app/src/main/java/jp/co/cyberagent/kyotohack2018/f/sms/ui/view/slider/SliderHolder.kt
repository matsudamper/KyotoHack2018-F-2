package jp.co.cyberagent.kyotohack2018.f.sms.ui.view.slider

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewContentSliderHolderBinding


data class SliderHolder<T : Any?>(
        private val title: String,
        private val sliderItemList: List<SliderData<T>>,
        private val onClickListener: ((T) -> Unit)
) : BindableItem<ViewContentSliderHolderBinding>() {

    override fun getLayout(): Int = R.layout.view_content_slider_holder

    override fun bind(viewBinding: ViewContentSliderHolderBinding, position: Int) {
        viewBinding.title.text = title
        viewBinding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
            sliderItemList.forEach {
                add(SliderItem(it) { onClickListener(it) })
            }
        }
    }
}