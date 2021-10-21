package com.example.sharedpreferencesbonus

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var txt1 : TextView

    lateinit var btnGet : Button
    lateinit var shps: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txt1=findViewById(R.id.txt1)

        btnGet=findViewById(R.id.btnGet)

       shps=this.getSharedPreferences(
            getString(R.string.preference_file_key), MODE_PRIVATE
        )
        var name = intent.getStringExtra("Name")
        var name2 = intent.getStringExtra("Name2")
        txt1.text = "$name \n $name2"


        btnGet.setOnClickListener {
            val x = shps.getString("data","")
            txt1.text = "$x"
        }



    }
}