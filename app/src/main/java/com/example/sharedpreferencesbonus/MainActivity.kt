package com.example.sharedpreferencesbonus

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.time.Instant

class MainActivity : AppCompatActivity() {
    lateinit var edName: EditText
    lateinit var edName2: EditText
    lateinit var btnIntent: Button
    lateinit var btnSherd: Button
    lateinit var shps: SharedPreferences

    var saved = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edName = findViewById(R.id.edName)
        edName2 = findViewById(R.id.edName2)
        btnIntent = findViewById(R.id.btnIntent)
        btnSherd = findViewById(R.id.btnSherd)


        shps=this.getSharedPreferences(
            getString(R.string.preference_file_key), MODE_PRIVATE
        )

        btnIntent.setOnClickListener {
            var intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("Name",edName.text.toString())
            intent.putExtra("Name2",edName2.text.toString())
            startActivity(intent)
        }
        btnSherd.setOnClickListener {
            saved="${edName.text} ${edName2.text}"
            sh()
        }
    }
    fun sh (){

        with(shps.edit()){
            putString("data",saved)
            apply()
            Toast.makeText(applicationContext, "Data is saved", Toast.LENGTH_SHORT).show()
        }
    }
}