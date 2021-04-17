package com.example.ejemplo02intents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo02intents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Atras"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        if (bundle != null && bundle.getString("saludo") != null){
            val saludo = bundle.getString("saludo")
            binding.textViewIntent.text = saludo
        }else{
            Toast.makeText(this,"Esta vacío", Toast.LENGTH_SHORT).show()
        }

        binding.btnSiguiente.setOnClickListener{
            startActivity(this,thirdActivity::class.java)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun startActivity(activity: Activity, nextActivity: Class<*>) {
        val intent = Intent(activity, nextActivity)
        //intent.putExtra("saludo", saludo)
        activity.startActivity(intent)
        activity.finish()
    }
}
