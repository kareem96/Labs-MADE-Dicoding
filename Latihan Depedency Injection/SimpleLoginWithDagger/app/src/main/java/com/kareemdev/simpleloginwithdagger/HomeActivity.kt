package com.kareemdev.simpleloginwithdagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kareemdev.simpleloginwithdagger.databinding.ActivityHomeBinding
import org.koin.android.ext.android.inject
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    /*val userRepository: UserRepository by inject()*/
    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val sesi = SessionManager(this)
        userRepository = UserRepository.getInstance(sesi)*/

        binding.tvWelcome.text = "Welcome ${userRepository.getUser()}"
        binding.btnLogout.setOnClickListener {
            userRepository.logoutUser()
            moveToMainActivity()
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}