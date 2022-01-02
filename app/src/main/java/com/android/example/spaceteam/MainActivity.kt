package com.android.example.spaceteam

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.android.example.spaceteam.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var pseudoTxt = ""


        binding.connectButton.setOnClickListener {
            pseudoTxt = binding.inputPseudo.text.toString()
            if (pseudoTxt != ""){
                me?.pseudo = pseudoTxt
                binding.me = me
                val intent = Intent(this, WatingRoom::class.java)
                startActivity(intent)
                binding.noPseudoError.visibility = View.INVISIBLE
            } else {
                binding.noPseudoError.visibility = View.VISIBLE
            }
        }
    }
    private val me: Players = Players(1)
}