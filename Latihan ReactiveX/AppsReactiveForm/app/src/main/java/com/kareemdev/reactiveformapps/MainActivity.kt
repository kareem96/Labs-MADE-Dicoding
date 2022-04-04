package com.kareemdev.reactiveformapps

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.core.content.ContextCompat
import com.jakewharton.rxbinding2.widget.RxTextView
import com.kareemdev.reactiveformapps.databinding.ActivityMainBinding
import io.reactivex.Observable
import io.reactivex.functions.Function3

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var emailValid = false
    private var passwordValid = false
    private var passwordConfirmationValid = false

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        validationButton()
        /*binding.edEmail.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validateEmail()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validatePassword()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edConfirmPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validatePasswordConfirmation()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })*/

        val emailStream =  RxTextView.textChanges(binding.edEmail)
            .skipInitialValue()
            .map { email ->
                !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }
        emailStream.subscribe {
            showEmailExistAlert(it)
        }

        val passwordStream = RxTextView.textChanges(binding.edPassword)
            .skipInitialValue()
            .map { password ->
                password.length < 6
            }
        passwordStream.subscribe{
            showPasswordMinimalAlert(it)
        }

        val passwordConfirmationStream = Observable.merge(
            RxTextView.textChanges(binding.edPassword)
                .map { password ->
                    password.toString() != binding.edConfirmPassword.text.toString()
                },
            RxTextView.textChanges(binding.edConfirmPassword)
                .map { confirmPassword ->
                    confirmPassword.toString() != binding.edPassword.text.toString()
                }
        )
        passwordConfirmationStream.subscribe {
            showPasswordConfirmationAlert(it)
        }

        val invalidFieldStream = Observable.combineLatest(
            emailStream,
            passwordStream,
            passwordConfirmationStream,
            Function3 { emailInvalid: Boolean, passwordInvalid: Boolean, passwordConfirmationInvalid: Boolean ->
                !emailInvalid && !passwordInvalid && !passwordConfirmationInvalid
            }
        )
        invalidFieldStream.subscribe { isValid ->
            if(isValid){
                binding.btnRegister.isEnabled = true
                binding.btnRegister.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500))
            }else{
                binding.btnRegister.isEnabled = false
                binding.btnRegister.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
            }
        }

    }



    private fun showPasswordConfirmationAlert(b: Boolean) {
        binding.edConfirmPassword.error = if(b) getString(R.string.password_not_same) else null
    }


    private fun showPasswordMinimalAlert(b: Boolean) {
        binding.edPassword.error = if(b) getString(R.string.password_not_valid) else null
    }


    private fun showEmailExistAlert(b: Boolean) {
        binding.edEmail.error = if(b) getString(R.string.email_not_valid) else null
    }

    /*private fun validatePasswordConfirmation() {
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

    private fun validationButton() {
        if(emailValid && passwordValid && passwordConfirmationValid){
            binding.btnRegister.isEnabled = true
            binding.btnRegister.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500))
        }else{
            binding.btnRegister.isEnabled = true
            binding.btnRegister.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
        }
    }*/
}