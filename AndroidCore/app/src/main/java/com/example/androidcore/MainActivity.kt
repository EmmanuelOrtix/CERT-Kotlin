package com.example.androidcore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidcore.databinding.ActivityMainBinding
import com.example.androidcore.toast.ToastActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        buttonGotoast()
    }

    fun buttonGotoast(){
        binding.btnToast.setOnClickListener {
            startActivity(Intent(this, ToastActivity::class.java))
        }
    }
}