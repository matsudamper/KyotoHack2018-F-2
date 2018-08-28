package jp.co.cyberagent.kyotohack2018.f.sms.ui.content

import android.content.Context
import android.content.Intent
import android.net.UrlQuerySanitizer
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.co.cyberagent.kyotohack2018.f.android_lib.bundle
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.Config
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivityContentBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux.ContentActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux.ContentStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.item.PlayCompanyItem
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.item.PlayDescriptionItem
import org.koin.android.ext.android.inject


class ContentActivity : AppCompatActivity() {

    private val contentCard: ContentCard by bundle()

    private val appActionCreator: AppActionCreator by inject()
    private val contentActionCreator: ContentActionCreator by inject()
    private val contentStore: ContentStore  by inject()

    private val youtube: YouTubePlayerSupportFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.youtube_fragment) as YouTubePlayerSupportFragment
    }

    companion object {
        fun createIntent(context: Context?, content: ContentCard) = Intent(context, ContentActivity::class.java).apply {
            putExtra(ContentActivity::contentCard.name, content)
        }
    }

    private val binding by lazy {
        DataBindingUtil.inflate<ActivityContentBinding>(LayoutInflater.from(this), R.layout.activity_content, null, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        contentStore.content
                .doIfNull { contentActionCreator.loadContent(contentCard.id) }
                .observeNotNull(this) { initializeView(it) }
    }

    private fun initializeView(content: Content) {
        UrlQuerySanitizer(content.movieUrl)
                .getValue("v")
                .doIfNotNull { id ->
                    youtube.initialize(Config.DEVELOPER_KEY, object : YouTubePlayer.OnInitializedListener {
                        override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, p2: Boolean) {
                            player?.loadVideo(id)
                        }

                        override fun onInitializationFailure(provider: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                            Toast.makeText(this@ContentActivity, "onInitializationFailure", Toast.LENGTH_SHORT).show()
                        }
                    })
                }

        binding.title.text = contentCard.title

        if (content.slideUrls == null) {
            binding.bottomSheet.layoutParams
                    .cast(CoordinatorLayout.LayoutParams::class.java)
                    .behavior = null
        }

        binding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
            add(PlayCompanyItem(content.company) {
                appActionCreator.openCompany(this@ContentActivity, content.company)
            })
            add(PlayDescriptionItem(content.description))

            // TODO ありえない
            add(PlayCompanyItem(content.company.copy(name = "投稿を見る")) {
                appActionCreator.openArticle(this@ContentActivity, content)
            })
        }
    }
}