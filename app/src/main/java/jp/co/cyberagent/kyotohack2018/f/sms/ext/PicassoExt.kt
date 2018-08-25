package jp.co.cyberagent.kyotohack2018.f.sms.ext

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(url: String) {
    Picasso.get()
            .load(url)
            .into(this)
}