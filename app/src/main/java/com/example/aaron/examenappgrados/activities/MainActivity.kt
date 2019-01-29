package com.example.aaron.examenappgrados.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.aaron.examenappgrados.R
import com.example.aaron.examenappgrados.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            .replace(R.id.content_main,MainFragment())
            .commit()
    }
}
