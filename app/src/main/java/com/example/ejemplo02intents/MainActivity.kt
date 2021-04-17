package com.example.ejemplo02intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplo02intents.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    val saludo = "Hola desde el Activity Main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.mipmap.ic_launcher)

        binding.btnCalcular.setOnClickListener{
            val añoNac : Int = binding.editTextNumber.text.
            toString().toInt()
            val añoActual = Calendar.getInstance().get(Calendar.YEAR)
            val miEdad = añoActual - añoNac
            binding.textView.text = "Tu edad es $miEdad años"

        }

        binding.btnSiguiente.setOnClickListener{
            startActivity(this,SecondActivity::class.java)
        }
    }

    fun startActivity(activity: Activity, nextActivity: Class<*>) {
        val intent = Intent(activity, nextActivity)
        intent.putExtra("saludo", saludo)
        activity.startActivity(intent)
        activity.finish()
    }
}
