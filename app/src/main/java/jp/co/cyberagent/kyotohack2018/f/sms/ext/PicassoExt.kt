package jp.co.cyberagent.kyotohack2018.f.sms.ext

import android.widget.ImageView
import com.squareup.picasso.Picasso
import jp.co.cyberagent.kyotohack2018.f.sms.R

fun ImageView.loadUrl(url: String) {

    if(url.isEmpty())
        Picasso.get()
                .load(resources.getColor(R.color.background_floating_material_dark))
                .into(this)
    else
        Picasso.get()
                .load(url)
                .into(this)
}