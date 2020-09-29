package com.example.kotilnmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        writeBtn.setOnClickListener {
            val Intent = Intent(this, WriteActivity::class.java)
            startActivity(Intent)
        }
    }
}