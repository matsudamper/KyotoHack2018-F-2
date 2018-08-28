package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.FragmentLoginBinding
import jp.co.cyberagent.kyotohack2018.f.sms.repository.AuthRepository
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.MainBaseFragment
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux.MainActivityActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.flux.LoginActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.flux.LoginStore
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : MainBaseFragment<FragmentLoginBinding>() {
    companion object {
        val REQUEST_ID = 100
    }

    override val titleResId = R.string.fragment_login
    override val layoutResId = R.layout.fragment_login
    override fun setTitle(titleResId: Int) = binding.toolBar.setTitle(titleResId)

    private val loginActionCreatorby: LoginActionCreator by inject()
    private val mainActionCreator: MainActivityActionCreator by inject()
    private val loginStore: LoginStore by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        loginStore.createAccount
                .subscribe {
                    mainActionCreator.changeFragment(requireFragmentManager(), R.id.my_page)
                }

        binding.signingIn.setOnClickListener {
            loginActionCreatorby.startAuth(requireActivity(), REQUEST_ID)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_ID) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)

                AuthRepository.apply {
                    name = account.displayName
                    idToken = account.idToken
                }

                loginActionCreatorby.firebaseAuthWithGoogle(account, requireActivity())
            } catch (e: ApiException) {
                e.printStackTrace()
            }
        }
    }
}