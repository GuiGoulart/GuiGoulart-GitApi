package com.challenge.magalu.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.challenge.magalu.data.model.RepositoryResponse
import com.challenge.magalu.data.paging.RepositoryDataSourceFactory
import com.challenge.magalu.data.server.ApiRequest
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel(apiRequest: ApiRequest) : ViewModel() {

    var newsList: LiveData<PagedList<RepositoryResponse.Item>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 5
    private var newsDataSourceFactory: RepositoryDataSourceFactory = RepositoryDataSourceFactory(apiRequest, compositeDisposable)

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        newsList = LivePagedListBuilder(newsDataSourceFactory, config).build()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}