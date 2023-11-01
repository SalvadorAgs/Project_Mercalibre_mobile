package com.example.prueba_mercado_libre.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*

import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import com.example.prueba_mercado_libre.R
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


class Login : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       //  Iniciar La vista
        initView()

        val tvLogin1 : TextView = findViewById(R.id.tvLogin1)
        val loginBtn: AppCompatButton = findViewById(R.id.btnLogin)
        val Splash_top : Animation? = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        val  Splash_bottom : Animation? = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        tvLogin1.setAnimation(Splash_top)
        loginBtn.setAnimation(Splash_bottom)

    }

    fun initView() {
        var userEdt: EditText = findViewById(R.id.ediTextUserLogin)
        var passEdt: EditText = findViewById(R.id.ediTextPasswordLogin)
        val loginBtn: AppCompatButton = findViewById(R.id.btnLogin)
        //Se declaran mensajes custom para validar Usuario o Contraseña
        val otherLayout: View = LayoutInflater.from(this).inflate(R.layout.cuestom_toast, null)
        val linearLayoutEmpty: LinearLayout = otherLayout.findViewById(R.id.ll_wrapper)
        val layoutEmptyToast = layoutInflater.inflate(R.layout.cuestom_toast, linearLayoutEmpty)


        loginBtn.setOnClickListener {
            if (userEdt.text.toString().isEmpty() || passEdt.text.toString().isEmpty()) {
                MotionToast.darkColorToast(
                    this,
                    "Error",
                    "Por Favor llena tu usuario y contraseña",
                    MotionToastStyle.DELETE,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )

            }
            else if (userEdt.text.toString().equals("test")&& passEdt.text.toString().equals("test")){
                 val intent = Intent(this, Dashboard::class.java)
                startActivity(intent);

            }
            else if (userEdt.text.toString()!=="test"|| passEdt.text.toString() !=="test"){
                MotionToast.darkColorToast(
                    this,
                    "Error",
                    "Usuario o Contraseña Incorrecto",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }

        }


    }



    override fun finish() {
        super.finish()
        this@Login.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}


