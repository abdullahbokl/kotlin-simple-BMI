package com.example.normal_bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.normal_bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clickMe.setOnClickListener {
            val height = binding.heightInCm.text.toString().toDouble()
            val weight = binding.weightInKg.text.toString().toDouble()
            val bmi = calculateBmi(weight, height/100.0)
            binding.bmiResult.text = String.format("%.1f", bmi)
            binding.healthStatus.text = when {
                bmi < 18.5 -> "Underweight"
                bmi < 24.9 -> "Normal"
                bmi < 29.9 -> "Overweight"
                else -> "Obese"
            }
        }
    }

    private fun calculateBmi(weight: Double, height: Double): Double {
        return weight / (height * height)
    }
}