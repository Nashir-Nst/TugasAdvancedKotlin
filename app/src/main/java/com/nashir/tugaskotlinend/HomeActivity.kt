package com.nashir.tugaskotlinend

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nashir.tugaskotlinend.adapter.RsAdapter
import com.nashir.tugaskotlinend.databinding.ActivityHomeBinding
import com.nashir.tugaskotlinend.model.Hospital
import com.nashir.tugaskotlinend.utils.CustomSharePreferneces

class HomeActivity : AppCompatActivity() {

    private lateinit var adapterRs: RsAdapter

    private lateinit var binding: ActivityHomeBinding
    private lateinit var preferneces: CustomSharePreferneces
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        hospital()
        checkLogin()
        logoutClick()
        setRvAdapter()


    }

    private fun hospital() {
        binding.rvHospital.layoutManager = LinearLayoutManager(this@HomeActivity)
    }

    private fun setRvAdapter() {
        val dataList: MutableList<Hospital> = mutableListOf()

        val images = imageHospital()
        val names = nameHospital()
        val addresses = alamatHospital()
        val phoneNumbers = phonenumber()


        val minLength = minOf(names.size, addresses.size, phoneNumbers.size, images.size)

        for (index in 0 until minLength) {
            dataList.add(Hospital(images[index], names[index], addresses[index], phoneNumbers[index]))
        }

        Log.d("ISI DATANYA ", dataList.toString())
        adapterRs = RsAdapter(dataList)
        binding.rvHospital.adapter = adapterRs
    }


    private fun imageHospital():List<Int> = listOf(
        R.drawable.sentramedika,
        R.drawable.simapangan_depok,
        R.drawable.tugu_ibu
    )

    private fun nameHospital():Array<String> = resources.getStringArray(R.array.data_name)
    private fun alamatHospital():Array<String> = resources.getStringArray(R.array.data_alamat)
    private fun phonenumber():Array<String> = resources.getStringArray(R.array.data_phone)


    private fun init() {
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