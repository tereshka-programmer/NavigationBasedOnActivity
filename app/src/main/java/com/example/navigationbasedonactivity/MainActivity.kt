package com.example.navigationbasedonactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigationbasedonactivity.databinding.ActivityMainBinding
import com.example.navigationbasedonactivity.model.Options
import java.lang.IllegalArgumentException

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var options: Options

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btExit.setOnClickListener { onExitPressed() }
        binding.btAbout.setOnClickListener { onAboutPressed() }
        binding.btOptions.setOnClickListener { onOptionsPressed() }
        binding.btOpenBox.setOnClickListener { onOpenBoxPressed() }

        options = savedInstanceState?.getParcelable(KEY_OPTIONS) ?: Options.DEFAULT
    }

    private fun onOpenBoxPressed() {
        val intent = Intent(this, BoxSelectionActivity::class.java)
        intent.putExtra(BoxSelectionActivity.EXTRA_OPTIONS, options)
        startActivity(intent)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OPTIONS_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            options = data?.getParcelableExtra(OptionsActivity.EXTRA_OPTIONS)
                ?: throw IllegalArgumentException("Can't get the updated data from options activity")
        }
    }

    private fun onOptionsPressed() {
        val intent = Intent(this, OptionsActivity::class.java)
        intent.putExtra(OptionsActivity.EXTRA_OPTIONS, options)
        startActivityForResult(intent, OPTIONS_REQUEST_CODE)
    }

    private fun onAboutPressed() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun onExitPressed() {
        finish()
    }

    companion object {
        const val KEY_OPTIONS = "OPTIONS"
        const val OPTIONS_REQUEST_CODE = 1
    }
}