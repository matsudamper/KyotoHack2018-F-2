package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.item

import android.widget.Toast
import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.category.Category
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewCategoryItemBinding

class CategoryItem(
        private val catogory: Category
) : BindableItem<ViewCategoryItemBinding>() {
    override fun getLayout() = R.layout.view_category_item

    override fun bind(viewHolder: ViewCategoryItemBinding, p1: Int) {
        viewHolder.title.text = catogory.name

        viewHolder.title.setOnClickListener {
            Toast.makeText(it.context, catogory.name, Toast.LENGTH_SHORT).show()
        }
    }
}