package com.android.example.spaceteam

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.example.spaceteam.databinding.ActivityGameBinding


class Game : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)
        binding.consigne = consigne

        findViewById<TextView>(R.id.degazerButton).setOnClickListener {
            binding.score = Score(14)
            val intent = Intent(this, GameOver::class.java)
            startActivity(intent)
        }
    }
    private val consigne: Consigne = Consigne(1,"Il y a trop de gaz !")


}