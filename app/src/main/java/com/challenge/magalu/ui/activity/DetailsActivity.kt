package com.challenge.magalu.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import com.challenge.magalu.R
import com.challenge.magalu.data.model.RepositoryPullsResponse
import com.challenge.magalu.databinding.ActivityDetailsBinding
import com.challenge.magalu.ui.adapter.DetailsAdapter
import com.challenge.magalu.ui.listener.DetailsAdapterListener
import com.challenge.magalu.ui.listener.DetailsViewModelListener
import com.challenge.magalu.ui.viewModel.DetailsViewModel
import org.koin.android.ext.android.inject

class DetailsActivity : AppCompatActivity(), DetailsViewModelListener, DetailsAdapterListener {

    private lateinit var binding: ActivityDetailsBinding

    private val detailsViewModel: DetailsViewModel by inject()

    private val detailsAdapter: DetailsAdapter by lazy { DetailsAdapter(this, this) }

    var name: String = ""
    private var repository: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initView()
    }

    private fun initView() {
        setupSettings()
        setupAdapters()
    }

    private fun setupAdapters() {
        binding.detaisRepositoryList.adapter = detailsAdapter
        binding.detaisRepositoryList.setHasFixedSize(true)
    }

    private fun setupSettings() {

        binding.detaisToolbar.setNavigationOnClickListener { onBackPressed() }

        intent.extras?.let{
            name = it.getString("name").toString()
            repository = it.getString("repository").toString()
        }

        binding.detaisCollapsingToolbarLayout.title = repository

        detailsViewModel.getReposRepositoryPull(name, repository, this)
    }

    override fun completListRepository(listItem: List<RepositoryPullsResponse>) {
        if (!listItem.isNullOrEmpty()) {
            binding.detaisLoader.visibility = View.GONE
            detailsAdapter.setList(listItem)
            binding.detaisRepositoryList.visibility = View.VISIBLE
        } else {
            binding.detaisRepositoryList.visibility = View.GONE
            binding.detaisListEmpty.visibility = View.VISIBLE
        }
    }

    override fun errorListRepository() {
        binding.detaisRepositoryList.visibility = View.GONE
        binding.detaisListEmpty.visibility = View.VISIBLE
    }

    override fun clicable(urlPull: String) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("urlPull", urlPull)
        intent.putExtra("repository", repository)
        val activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(
            this,
            R.anim.fade_in,
            R.anim.move_right
        )
        ActivityCompat.startActivity(this, intent, activityOptionsCompat.toBundle())
    }
}