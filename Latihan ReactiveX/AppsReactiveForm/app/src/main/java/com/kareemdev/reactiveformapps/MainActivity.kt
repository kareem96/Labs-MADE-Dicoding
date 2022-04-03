package com.kareemdev.reactiveformapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.core.content.ContextCompat
import com.kareemdev.reactiveformapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var emailValid = false
    private var passwordValid = false
    private var passwordConfirmationValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        validationButton()

        binding.edEmail.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validateEmail()
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        })

        binding.edPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validatePassword()
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        })

        binding.edConfirmPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validatePasswordConfirmation()
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun validatePasswordConfirmation() {
        val input = binding.edConfirmPassword.text.toString()
        if(input != binding.edPassword.text.toString()){
            passwordConfirmationValid = false
            showPasswordConfirmationAlert(true)
        }else{
            passwordConfirmationValid = true
            showPasswordConfirmationAlert(false)
        }
        validationButton()
    }

    private fun showPasswordConfirmationAlert(b: Boolean) {
        binding.edConfirmPassword.error = if(b) getString(R.string.password_not_same) else null
    }

    private fun validatePassword() {
        val input = binding.edPassword.text.toString()
        if(input.length < 6){
            passwordValid = false
            showPasswordMinimalAlert(true)
        }else{
            passwordValid = true
            showPasswordMinimalAlert(false)
        }
        validationButton()

    }

    private fun showPasswordMinimalAlert(b: Boolean) {
        binding.edPassword.error = if(b) getString(R.string.password_not_valid) else null
    }

    private fun validateEmail() {
        val input = binding.edEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(input).matches()){
            emailValid = false
            showEmailExistAlert(true)
        }else{
            emailValid = true
            showEmailExistAlert(false)
        }
        validationButton()
    }

    private fun showEmailExistAlert(b: Boolean) {
        binding.edEmail.error = if(b) getString(R.string.email_not_valid) else null
    }

    private fun validationButton() {
        if(emailValid && passwordValid && passwordConfirmationValid){
            binding.btnRegister.isEnabled = true
            binding.btnRegister.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500))
        }else{
            binding.btnRegister.isEnabled = true
            binding.btnRegister.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
        }
    }
}