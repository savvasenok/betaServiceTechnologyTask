package xyz.savvamirzoyan.betaservicetechnology.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import timber.log.Timber
import xyz.savvamirzoyan.betaservicetechnology.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Timber.i("onCreate() called")
    }
}