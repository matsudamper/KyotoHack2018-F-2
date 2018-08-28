package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.flux

import android.annotation.SuppressLint
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.service.sms.RegistUser
import jp.co.cyberagent.kyotohack2018.f.sms.Config
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.repository.AuthRepository
import jp.co.cyberagent.kyotohack2018.f.sms.repository.LoginRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class LoginActionCreator(
        private val appActionCreator: AppActionCreator,
        private val dispatcher: LoginDispatcher,
        private val loginRepository: LoginRepository
) : KoinComponent {
    private val mAuth: FirebaseAuth by inject()
    private val loginStore: LoginStore by inject()

    @SuppressLint("CheckResult")
    fun createAccount(user: RegistUser) {
        loginRepository.createAccount(user)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    dispatcher.dispatch(LoginAction.CreateAccount(it))
                }, {
                    appActionCreator.displayError(it)
                })
    }

    // Auth
    fun startAuth(fragmentActivity: FragmentActivity, REQUEST_ID: Int) {
        val mGoogleSignInClient = GoogleSignIn.getClient(fragmentActivity, gso)
        fragmentActivity.startActivityForResult(mGoogleSignInClient.signInIntent, REQUEST_ID)
    }

    private val gso by lazy {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(Config.ANDROID_KEY)
                .requestEmail()
                .build()
    }

    fun firebaseAuthWithGoogle(acct: GoogleSignInAccount, activity: FragmentActivity) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser ?: return@addOnCompleteListener

                        AuthRepository.apply { uuid = user.uid }

                        // TODO エラーハンドリング
                        val uuid = AuthRepository.uuid ?: return@addOnCompleteListener
                        val email = AuthRepository.email ?: return@addOnCompleteListener
                        val name = AuthRepository.name ?: return@addOnCompleteListener
                        createAccount(RegistUser(
                                uid = uuid,
                                email = email,
                                name = name))
                    }
                }
    }
}