package com.example.homework2_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework2_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnClock.setOnClickListener {
            startActivity(Intent(this, Alarm::class.java))
        }
        binding.btnStopwatch.setOnClickListener {
            startActivity(Intent(this, StopClock::class.java))
        }
        binding.btnTimer.setOnClickListener {
            startActivity(Intent(this, Time::class.java))
        }
    }
}