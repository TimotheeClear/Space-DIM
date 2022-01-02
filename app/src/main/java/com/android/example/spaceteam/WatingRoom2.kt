package com.android.example.spaceteam

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import com.android.example.spaceteam.databinding.ActivityMainBinding
import com.android.example.spaceteam.databinding.ActivityWatingRoom2Binding


class WatingRoom2 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingWR2: ActivityWatingRoom2Binding
    lateinit var monRecycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingWR2 = DataBindingUtil.setContentView(this, R.layout.activity_wating_room2)
        bindingWR2.room = room

        val toggle: ToggleButton = bindingWR2.readyButton
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                toggle.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.red))
                /*ERROR*/
                /*binding.me.state = false  => Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type Players?*/
                /*binding.me?.state = false => crash
                */
            } else {
                toggle.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.green))
                /*ERROR*/
                /*binding.me.state = true  => Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type Players?*/
                /*binding.me?.state = true => crash
                */

                val intent = Intent(this, Game::class.java)
                startActivity(intent)
            }
        }

        val players = room.participans
        monRecycler = findViewById(R.id.playersList)
        monRecycler.layoutManager = LinearLayoutManager(this)
        monRecycler.adapter = PlayersAdapter(players.toTypedArray()){}
    }

    fun CreerMesLigne() : ArrayList<Players>
    {
        val players = ArrayList<Players>()

        /*ERROR*/
        /*players.add(binding.me) => Type mismatch: inferred type is Players? but Players was expected*/
        players.add(Players(2,"Truc",true))
        players.add(Players(3,"Bidule",false))
        return players
    }

    private val room: Room = Room(1,"my ROOM", CreerMesLigne())
}