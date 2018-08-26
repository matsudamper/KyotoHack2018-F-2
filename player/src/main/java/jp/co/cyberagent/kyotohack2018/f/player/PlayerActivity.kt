package jp.co.cyberagent.kyotohack2018.f.player

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import jp.co.cyberagent.kyotohack2018.f.android_lib.bundle
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.player.databinding.ActivityPlayBinding

class PlayerActivity : AppCompatActivity() {

    val content: Content by bundle()

    companion object {
        fun createIntent(context: Context?, content: ContentCard) = Intent(context, PlayerActivity::class.java).apply {
            putExtra(PlayerActivity::content.name, content)
        }
    }

    private val binding by lazy {
        DataBindingUtil.inflate<ActivityPlayBinding>(LayoutInflater.from(this), R.layout.activity_play, null, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}