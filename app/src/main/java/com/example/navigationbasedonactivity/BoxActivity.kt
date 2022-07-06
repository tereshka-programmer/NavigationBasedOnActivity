package com.example.navigationbasedonactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigationbasedonactivity.databinding.ActivityBoxBinding

class BoxActivity : BaseActivity() {

    private lateinit var binding: ActivityBoxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoxBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.toMainMenuButton.setOnClickListener { onToMainPressed() }
    }

    private fun onToMainPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }
}