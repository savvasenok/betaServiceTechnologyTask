package xyz.savvamirzoyan.betaservicetechnology.`interface`

import androidx.lifecycle.MutableLiveData

interface ILogin {

    interface View {
        fun setOnChangedEditTextLoginListener()
        fun setOnChangedEditTextPasswordListener()
        fun setOnButtonLoginClickedListener()
        fun setOnIsButtonEnableListener()
    }

    interface ViewModel {
        val isLoginButtonEnable: MutableLiveData<Boolean>

        fun updateLogin(newLogin: String)
        fun updatePassword(newPassword: String)

        fun onButtonClick()
    }
}