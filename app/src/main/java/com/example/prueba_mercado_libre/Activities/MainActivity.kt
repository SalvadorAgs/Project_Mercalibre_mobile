package com.example.prueba_mercado_libre.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.prueba_mercado_libre.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  btnInit : Button = findViewById(R.id.btnIntro)
        btnInit.setOnClickListener {
             val intent = Intent(this, Login::class.java)
             startActivity(intent);

        }


    }


    override fun finish() {
        super.finish()
        this@MainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

}