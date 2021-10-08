package com.challenge.magalu.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.challenge.magalu.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    private var url: String = ""
    private var repository: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initView()
    }

    private fun initView() {
        setupSettings()
    }


    @SuppressLint("SetJavaScriptEnabled")
    private fun setupSettings() {

        binding.webViewToolbar.setNavigationOnClickListener { onBackPressed() }

        intent.extras?.let{
            url = it.getString("urlPull").toString()
            repository = it.getString("repository").toString()
        }

        binding.webViewCollapsingToolbarLayout.title = repository

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl(url)

    }
}