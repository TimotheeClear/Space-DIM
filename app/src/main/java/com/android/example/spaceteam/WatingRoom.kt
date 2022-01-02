package com.android.example.spaceteam

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class WatingRoom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wating_room)

        findViewById<TextView>(R.id.joinRoomButton).setOnClickListener {
            val intent = Intent(this, WatingRoom2::class.java)
            startActivity(intent)
        }
    }
}