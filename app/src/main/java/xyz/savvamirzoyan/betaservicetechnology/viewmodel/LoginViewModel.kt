package xyz.savvamirzoyan.betaservicetechnology.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber
import xyz.savvamirzoyan.betaservicetechnology.`interface`.ILogin

// Minimum length of login and password
private const val MIN_LENGTH = 8

class LoginViewModel : ViewModel(), ILogin.ViewModel {

    private var login = ""
        set(value) {
            field = value
            Timber.i("login setter called | value: $value")
            isValidLogin = value.length >= MIN_LENGTH
        }
    private var password = ""
        set(value) {
            field = value
            Timber.i("password setter called | value: $value")
            isValidPassword = value.length >= MIN_LENGTH
        }

    private var isValidLogin = false
        set(value) {
            field = value
            Timber.i("isValidLogin setter called | value: $value")
            isLoginButtonEnable.postValue(value && isValidPassword)
        }
    private var isValidPassword = false
        set(value) {
            field = value
            Timber.i("isValidPassword setter called | value: $value")
            isLoginButtonEnable.postValue(value && isValidLogin)
        }

    override val isLoginButtonEnable = MutableLiveData<Boolean>()

    init {
        Timber.i("initialized")
    }

    override fun updateLogin(newLogin: String) {
        Timber.i("updateLogin() called | newLogin: $newLogin")
        login = newLogin
    }

    override fun updatePassword(newPassword: String) {
        Timber.i("updatePassword() called | newPassword: $newPassword")
        password = newPassword
    }

    override fun onButtonClick() {
        Timber.i("onButtonClick() called")
    }
}