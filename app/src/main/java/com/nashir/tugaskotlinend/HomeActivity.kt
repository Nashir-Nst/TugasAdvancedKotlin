package com.nashir.tugaskotlinend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nashir.tugaskotlinend.databinding.ActivityHomeBinding
import com.nashir.tugaskotlinend.utils.CustomSharePreferneces

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var preferneces: CustomSharePreferneces
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        checkLogin()
        logoutClick()


    }

    fun init() {
        preferneces = CustomSharePreferneces(this@HomeActivity)
    }

    fun checkLogin() {
        if (preferneces.getlogin(1).equals(0)) {
            val intent = Intent(this@HomeActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun logoutClick() {
        binding.btnLogout.setOnClickListener {
            preferneces.saveLogin(0).let {
                val intent = Intent(this@HomeActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}