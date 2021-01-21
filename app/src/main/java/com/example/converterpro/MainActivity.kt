package com.example.converterpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun length_convert(view: View) {
        val intent = Intent(this,ConverterActivity::class.java)
        Toast.makeText(this,"Length Converter",Toast.LENGTH_SHORT).show()
        //This is imported
        //here we puted intent
        intent.putExtra("option",1)
        startActivity(intent)
    }
    fun currency_convert(view: View) {
        val intent = Intent(this,ConverterActivity::class.java)
        Toast.makeText(this,"Currency Converter",Toast.LENGTH_SHORT).show()
        intent.putExtra("option",2)
        startActivity(intent)
    }
    fun temperature_convert(view: View) {
        val intent = Intent(this,ConverterActivity::class.java)
        Toast.makeText(this,"Temperature Converter",Toast.LENGTH_SHORT).show()
        intent.putExtra("option",3)
        startActivity(intent)
    }
}