package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.co.cyberagent.kyotohack2018.f.model.category.Category
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.FragmentSearchBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.println
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainBaseFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux.SearchActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux.SearchStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.ContentlItem
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : MainBaseFragment<FragmentSearchBinding>() {
    override val titleResId = R.string.fragment_search
    override val layoutResId = R.layout.fragment_search
    override fun setTitle(layoutResId: Int) = binding.toolBar.setTitle(layoutResId)

    private val appActionCreator: AppActionCreator by inject()
    private val searchActionCreator: SearchActionCreator by inject()
    private val searchStore: SearchStore by viewModel()

    private val adapterOne = CategoryAdapter()
    private val adapterTwo = CategoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchStore.categories
                .doIfNull { searchActionCreator.loadCategories() }
                .observeNotNull(this) { initCategories(it) }

        searchStore.searchContents
                .observeNotNull(this) { setContent(it) }

        BottomSheetBehavior.from(binding.bottomSheet)
                .setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(p0: View, p1: Float) {}

                    override fun onStateChanged(p0: View, state: Int) {
                        if (state == BottomSheetBehavior.STATE_COLLAPSED) {
                            val firstSelectItems = adapterOne.items.filter { it.second }.map { it.first.id }
                            val secondSelectItems = adapterTwo.items.filter { it.second }.map { it.first.id }

                            if (firstSelectItems.isEmpty() && secondSelectItems.isEmpty()) {
                                Toast.makeText(requireContext(), "一つ以上要素を選択して下さい", Toast.LENGTH_SHORT).show()
                                openSheet()
                                return
                            }

                            searchActionCreator.searchContents(listOf(firstSelectItems, secondSelectItems))
                        }
                    }
                })

        openSheet()
    }

    private fun initCategories(categories: Map<String, List<Category>>) {
        if (categories.size < 2) return

        categories.keys.iterator().apply {
            next().let { first ->
                binding.recyclerViewLanguage.layoutManager = FlexboxLayoutManager(context).apply {
                    flexDirection = FlexDirection.ROW
                }
                binding.recyclerViewLanguage.adapter = adapterOne.apply {
                    val categories = categories[first] ?: return
                    items.addAll(categories.map { it to false })
                }
            }

            next().let { second ->
                binding.recyclerViewPlatform.layoutManager = FlexboxLayoutManager(context).apply {
                    flexDirection = FlexDirection.ROW
                }
                binding.recyclerViewPlatform.adapter = adapterTwo.apply {
                    val categories = categories[second] ?: return
                    items.addAll(categories.map { it to false })
                }
            }
        }
    }

    private fun setContent(contentCards: List<ContentCard>) {
        contentCards.println()
        binding.recyclerView.swapAdapter(GroupAdapter<ViewHolder>().apply {
            addAll(contentCards.map {
                ContentlItem(it) {
                    appActionCreator.openContent(requireContext(), it)
                }
            })
        }, false)
    }

    private fun openSheet() {
        val behavior = BottomSheetBehavior.from(binding.bottomSheet)
        binding.bottomSheet.postDelayed({
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }, 500)
    }
}