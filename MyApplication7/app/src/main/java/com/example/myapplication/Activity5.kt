package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_5.*
import kotlinx.android.synthetic.main.activity_main.*

class Activity5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)

        button6.setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }

        button7.setOnClickListener {
            startActivity(Intent(this, Activity4::class.java))
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
