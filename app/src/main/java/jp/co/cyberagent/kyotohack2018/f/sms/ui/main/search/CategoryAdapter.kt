package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import jp.co.cyberagent.kyotohack2018.f.model.category.Category
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewCategoryItemBinding


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    val items: MutableList<Pair<Category, Boolean>> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val binding = holder.binding

        fun changeColor() {
            binding.root.apply {
                background = when (item.second) {
                    true -> resources.getDrawable(R.drawable.tag_blue, null)
                    false -> resources.getDrawable(R.drawable.tag_gray, null)
                }
            }
        }

        binding.title.text = item.first.name
        changeColor()

        binding.root.setOnClickListener {
            items.removeAt(position)
            items.add(position, item.copy(second = item.second.not()))
            changeColor()
            notifyItemChanged(position)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ViewCategoryItemBinding = DataBindingUtil.bind(view)!!
    }
}