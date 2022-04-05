package com.kareemdev.simpleloginwithdagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kareemdev.simpleloginwithdagger.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /*private val userRepository: UserRepository by inject()*/
    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var userRepository2: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRepository.checkInstance()
        userRepository2.checkInstance()

        /*val sesi = SessionManager(this)
        userRepository = UserRepository.getInstance(sesi)*/

        if(userRepository.isUserLogin()){
            moveToHomeActivity()
        }
        binding.btnLogin.setOnClickListener { saveSession() }
    }

    private fun saveSession() {
        userRepository.loginUser(binding.edUsername.text.toString())
        moveToHomeActivity()
    }

    private fun moveToHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}