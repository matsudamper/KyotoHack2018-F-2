package jp.co.cyberagent.kyotohack2018.f.sms.repository

import com.chibatching.kotpref.KotprefModel

object AuthRepository : KotprefModel() {
    var uuid by nullableStringPref()
    var accessToken by nullableStringPref()
}