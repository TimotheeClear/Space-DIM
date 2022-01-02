package com.android.example.spaceteam

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.example.spaceteam.databinding.ActivityGameBinding
import com.android.example.spaceteam.databinding.ActivityGameOverBinding

class GameOver : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var bindingGO: ActivityGameOverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingGO = DataBindingUtil.setContentView(this, R.layout.activity_game_over)
/*ERROR
        bindingGO.scoreDisplay.text = binding.score.valeur.toString() => Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type Score?
*/
        bindingGO.tryAgainButton.setOnClickListener{
            val intent = Intent(this, WatingRoom2::class.java)
            startActivity(intent)
        }
    }
}