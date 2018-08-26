package jp.co.cyberagent.kyotohack2018.f.sms.ui.content

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import jp.co.cyberagent.kyotohack2018.f.android_lib.bundle
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.Config
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivityContentBinding


class ContentActivity : AppCompatActivity() {

    private val contentCard: ContentCard by bundle()

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

        initializeView()
    }

    private fun initializeView() {
        youtube.initialize(Config.DEVELOPER_KEY, object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, p2: Boolean) {
                player?.loadVideo("dzEk6wZ4Xuc")
            }

            override fun onInitializationFailure(provider: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Toast.makeText(this@ContentActivity, "onInitializationFailure", Toast.LENGTH_SHORT).show()
            }
        })

        binding.title.text = contentCard.title

//        if (contentCard.slideUrls == null) {
//            binding.bottomSheet.layoutParams
//                    .cast(CoordinatorLayout.LayoutParams::class.java)
//                    .behavior = null
//        }
    }
}