package jp.co.cyberagent.kyotohack2018.f.sms.repository

import com.chibatching.kotpref.KotprefModel

object AuthRepository : KotprefModel() {
    var name by nullableStringPref()
    var uuid by nullableStringPref()
    var idToken by nullableStringPref()
    var email by nullableStringPref()
}