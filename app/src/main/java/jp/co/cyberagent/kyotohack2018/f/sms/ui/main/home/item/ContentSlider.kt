package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.item

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewContentSliderHolderBinding


data class ContentSlider(
        private val title: String,
        private val contentCardList: List<ContentCard>
) : BindableItem<ViewContentSliderHolderBinding>() {

    override fun getLayout(): Int = R.layout.view_content_slider_holder

    override fun bind(viewBinding: ViewContentSliderHolderBinding, position: Int) {
        viewBinding.title.text = title
        viewBinding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
            contentCardList.forEach { add(ContentSliderItem(it)) }
        }
    }
}