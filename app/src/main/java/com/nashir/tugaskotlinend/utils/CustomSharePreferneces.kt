package com.nashir.tugaskotlinend.utils

import android.content.Context
import android.content.SharedPreferences

data class CustomSharePreferneces(val context:Context){
    private val preferneces:SharedPreferences = context.getSharedPreferences("Simpan_Token", Context.MODE_PRIVATE)

    fun saveLogin(login:Int){
        val editor:SharedPreferences.Editor = preferneces.edit()
        editor.putInt("Simpan_Login", login)
        editor.apply()
    }

    fun saveEmail(email:String){
        val editor:SharedPreferences.Editor = preferneces.edit()
        editor.putString("Simpan_Email", email)
        editor.apply()
    }

    fun getlogin(login:Int) = preferneces.getInt("Simpan_Login", 0)

}
