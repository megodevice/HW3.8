package com.geeks.hw38

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.hw38.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        toolbar = binding.mainActivityToolbar
        setContentView(binding.root)
    }

    companion object {
        const val HERO = "hero1"
    }
}