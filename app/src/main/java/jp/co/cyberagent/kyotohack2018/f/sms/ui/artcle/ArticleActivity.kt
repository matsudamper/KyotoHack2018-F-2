package jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.co.cyberagent.kyotohack2018.f.android_lib.bundle
import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivityArticleBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.flux.ArticleActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.flux.ArticleStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.item.ArticleItem
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleActivity : AppCompatActivity() {

    private val appActionContent: AppActionCreator by inject()

    private val content: Content by bundle()
    private val articleStore: ArticleStore by viewModel()
    private val articleActionCreator: ArticleActionCreator by inject()

    companion object {
        fun createIntent(context: Context?, content: Content) = Intent(context, ArticleActivity::class.java).apply {
            putExtra(ArticleActivity::content.name, content)
        }
    }

    private val binding by lazy {
        DataBindingUtil.inflate<ActivityArticleBinding>(LayoutInflater.from(this), R.layout.activity_article, null, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toolBar.title = "投稿"

        articleStore.article
                .doIfNull { articleActionCreator.loadArticles(content.id) }
                .observeNotNull(this) {
                    createView(it)
                }

        binding.fab.setOnClickListener {
            appActionContent.openPost(this@ArticleActivity, content)
        }
    }

    private fun createView(items: List<Article>) {
        binding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
            items.forEach {
                add(ArticleItem(it) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it.url)))
                })
            }
        }
    }
}
