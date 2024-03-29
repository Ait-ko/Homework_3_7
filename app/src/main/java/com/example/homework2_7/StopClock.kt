package com.example.homework2_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.homework2_7.databinding.StopclocksBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StopClock : AppCompatActivity() {
    private val binding: StopclocksBinding by lazy {
        StopclocksBinding.inflate(layoutInflater)
    }
    private var isRunning = false
    private var seconds = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener {
            startStopwatch()
        }
        binding.btnStop.setOnClickListener {
            stopStopwatch()
        }
        binding.btnReset.setOnClickListener {
            resetStopwatch()
        }
    }

    private fun startStopwatch() {
        isRunning = true
        lifecycleScope.launch(Dispatchers.Main) {
            while (isRunning) {
                delay(1000)
                seconds++
                updateInterface()
            }
        }
    }

    private fun stopStopwatch() {
        isRunning = false
    }

    private fun resetStopwatch() {
        isRunning = false
        seconds = 0
        updateInterface()
    }

    private fun updateInterface() {
        val minutes = seconds / 60
        val hours = seconds / 3600
        val remainingSeconds = seconds % 60
        val timeString = String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds)
        binding.tvTime.text = timeString
    }
}