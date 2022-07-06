package com.example.navigationbasedonactivity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.BuildConfig
import com.example.navigationbasedonactivity.databinding.ActivityAboutBinding

class AboutActivity : BaseActivity() {

    lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.versionCodeTextView.text = com.example.navigationbasedonactivity.BuildConfig.VERSION_CODE.toString()
        binding.versionNameTextView.text = com.example.navigationbasedonactivity.BuildConfig.VERSION_NAME
        binding.okButton.setOnClickListener { onOkPressed() }
    }

    private fun onOkPressed() {
        finish()
    }
}