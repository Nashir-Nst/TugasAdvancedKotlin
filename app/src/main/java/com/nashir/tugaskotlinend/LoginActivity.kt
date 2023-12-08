package com.nashir.tugaskotlinend

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nashir.tugaskotlinend.databinding.ActivityLoginBinding
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

        private fun init() {
            preferences = CustomSharePreferneces(this@LoginActivity)
        }

        private fun checkCondition() {
            if (preferences.getlogin(1) != 0) {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        private fun loginClick() {
           binding.btnLogin.setOnClickListener{
               preferences.saveLogin(1).let {
                   val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                   startActivity(intent)
                   finish()
               }
           }
        }
    }
