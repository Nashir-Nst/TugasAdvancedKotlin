package com.nashir.tugaskotlinend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.nashir.tugaskotlinend.databinding.ActivityLoginBinding
import com.nashir.tugaskotlinend.databinding.ActivityMainBinding
import com.nashir.tugaskotlinend.utils.CustomSharePreferneces

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var preferences:CustomSharePreferneces

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        checkCondition()
        loginClick()
    }

        fun init() {
            preferences = CustomSharePreferneces(this@LoginActivity)
        }

        fun checkCondition() {
            if (!preferences.getlogin(1).equals(0)) {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        fun loginClick() {
           binding.btnLogin.setOnClickListener{
               preferences.saveLogin(1).let {
                   val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                   startActivity(intent)
                   finish()
               }
           }
        }
    }
