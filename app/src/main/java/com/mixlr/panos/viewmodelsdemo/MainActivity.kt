package com.mixlr.panos.viewmodelsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCount = findViewById<Button>(R.id.btnCount)
        val tvCount = findViewById<TextView>(R.id.tvCount)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.count.observe(this) {
            tvCount.text = it.toString()
        }

        btnCount.setOnClickListener {
            viewModel.updateCount()
        }
    }
}