package com.example.colormyviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.colormyviews.databinding.ActivityMainBinding
import android.view.View
import android.graphics.Color
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
                binding.boxFourText, binding.boxFiveText, binding.constraintLayout,
                binding.redButton, binding.yellowButton, binding.greenButton)
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view) {

            // Boxes using Color class colors for the background
            binding.boxOneText -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for the background
            binding.boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText-> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for the background
            binding.redButton -> binding.constraintLayout.setBackgroundColor(ContextCompat.getColor(
                applicationContext, R.color.my_red))
            binding.yellowButton  -> binding.constraintLayout.setBackgroundColor(ContextCompat.getColor(
                applicationContext, R.color.my_yellow))
            binding.greenButton  -> binding.constraintLayout.setBackgroundColor(ContextCompat.getColor(
                applicationContext, R.color.my_green))

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

}