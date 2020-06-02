package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_4.*
import kotlinx.android.synthetic.main.activity_main.*

class Activity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        button8.setOnClickListener {
            startActivity(Intent(this, Activity5::class.java))
        }

        button9.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }

        supportActionBar!!.title = "Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
