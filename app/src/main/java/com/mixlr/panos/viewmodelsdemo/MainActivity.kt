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

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val btnCount = findViewById<Button>(R.id.btnCount)
        val tvCount = findViewById<TextView>(R.id.tvCount)
        tvCount.text = viewModel.count.toString()

        btnCount.setOnClickListener {
            viewModel.updateCount()
            tvCount.text = viewModel.count.toString()
        }
    }
}