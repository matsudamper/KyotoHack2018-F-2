package jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.item

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewContentItemBinding

class ArticleItem(
        val article: Article,
        val onClick: (() -> Unit)
) : BindableItem<ViewContentItemBinding>() {

    override fun getLayout() = R.layout.view_content_item

    override fun bind(viewHolder: ViewContentItemBinding, p1: Int) {
        viewHolder.title.text = article.title
        viewHolder.root.setOnClickListener {
            onClick()
        }
    }
}