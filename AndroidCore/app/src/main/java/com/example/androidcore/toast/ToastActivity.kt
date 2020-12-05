package com.example.androidcore.toast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.androidcore.R
import com.example.androidcore.databinding.ActivityToastBinding

class ToastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToastBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "CERT Toasts"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        showToastGeneric()
        showToastModify()
    }

    fun showToastGeneric(){
        binding.btnToastOne.setOnClickListener{
            val text = "Hello toast!"
            val duration = Toast.LENGTH_LONG

            val toast = Toast.makeText(applicationContext, text, duration)
            //toast.setGravity(Gravity.TOP, 5, 0)
            toast.show()

        }
    }
    
    fun showToastModify(){
        binding.btnToastTwo.setOnClickListener {

            val inflater = layoutInflater
            val container: ViewGroup = findViewById(R.id.custom_toast_container)
            val layout = inflater.inflate(R.layout.custom_toasts, container) as ViewGroup
            val text: TextView = layout.findViewById(R.id.text)
            text.text = "este es un toast modificado"
            with(Toast(applicationContext)) {
                setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                duration = Toast.LENGTH_SHORT
                view = layout
                show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}