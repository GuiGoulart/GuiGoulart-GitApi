package com.challenge.magalu.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import com.challenge.magalu.R
import com.challenge.magalu.databinding.ActivityHomeBinding
import com.challenge.magalu.di.injectFeature
import com.challenge.magalu.ui.adapter.HomeAdapter
import com.challenge.magalu.ui.listener.HomeAdapterListener
import com.challenge.magalu.ui.viewModel.HomeViewModel
import org.koin.android.ext.android.inject

class HomeActivity : AppCompatActivity(), HomeAdapterListener {

    private lateinit var binding: ActivityHomeBinding

    private val homeViewModel: HomeViewModel by inject()

    private val homeAdapter: HomeAdapter by lazy { HomeAdapter(this, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        injectFeature()

        initView()

    }

    private fun initView() {
        setupAdapters()
        setupObservable()
    }

    private fun setupAdapters() {
        binding.homeRepositoryList.adapter = homeAdapter
        binding.homeRepositoryList.setHasFixedSize(true)
    }

    private fun setupObservable() {
        homeViewModel.newsList.observe(this, {
            if (!it.isNullOrEmpty()) {
                binding.homeLoader.visibility = View.GONE
                homeAdapter.submitList(it)
                binding.homeRepositoryList.visibility = View.VISIBLE
            } else {
                binding.homeRepositoryList.visibility = View.GONE
                binding.homeListEmpty.visibility = View.VISIBLE
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun clicable(name: String, repository: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("repository", repository)
        val activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(
            this,
            R.anim.fade_in,
            R.anim.move_right
        )
        ActivityCompat.startActivity(this, intent, activityOptionsCompat.toBundle())
    }
}