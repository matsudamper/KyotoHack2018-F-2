package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import jp.co.cyberagent.kyotohack2018.f.sms.Config
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.FragmentLoginBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainBaseFragment
import org.koin.android.ext.android.inject


class LoginFragment : MainBaseFragment<FragmentLoginBinding>() {
    override val titleResId = R.string.fragment_login
    override val layoutResId = R.layout.fragment_login
    override fun setTitle(titleResId: Int) = binding.toolBar.setTitle(titleResId)

    val mAuth: FirebaseAuth by inject()

    private val gso by lazy {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(Config.ANDROID_KEY)
                .requestEmail()
                .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.signingIn.setOnClickListener {
            val mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
            startActivityForResult(mGoogleSignInClient.signInIntent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)

                firebaseAuthWithGoogle(account)
                Log.d("LOG", "Result")
                Log.d("LOG", "$account")
                Log.d("LOG", "${account.account}")
                Log.d("LOG", "${account.email}")
                Log.d("LOG", "${account.id}")
                Log.d("LOG", "${account.idToken}")
                Log.d("LOG", "${account.toJson()}")
            } catch (e: ApiException) {
                e.printStackTrace()
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser
                    }
                }
    }
}