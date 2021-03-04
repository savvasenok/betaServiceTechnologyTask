package xyz.savvamirzoyan.betaservicetechnology

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import xyz.savvamirzoyan.betaservicetechnology.`interface`.ILogin
import xyz.savvamirzoyan.betaservicetechnology.databinding.FragmentLoginBinding
import xyz.savvamirzoyan.betaservicetechnology.viewmodel.LoginViewModel

class LoginFragment : Fragment(), ILogin.View {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setOnChangedEditTextLoginListener()
        setOnChangedEditTextPasswordListener()
        setOnButtonLoginClickedListener()
        setOnIsButtonEnableListener()

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun setOnChangedEditTextLoginListener() {
        binding.editTextLogin.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Timber.i("afterTextChanged() called | login: ${s.toString()}")
                viewModel.updateLogin(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun setOnChangedEditTextPasswordListener() {
        binding.editTextPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Timber.i("afterTextChanged() called | password: ${s.toString()}")
                viewModel.updatePassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun setOnButtonLoginClickedListener() {
        binding.buttonLogin.setOnClickListener { viewModel.onButtonClick() }
    }

    override fun setOnIsButtonEnableListener() {
        viewModel.isLoginButtonEnable.observe(viewLifecycleOwner) {
            binding.buttonLogin.isEnabled = viewModel.isLoginButtonEnable.value == true
        }
    }
}