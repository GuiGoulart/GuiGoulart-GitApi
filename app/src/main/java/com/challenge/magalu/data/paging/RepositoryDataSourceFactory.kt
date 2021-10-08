package com.challenge.magalu.data.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.challenge.magalu.data.model.RepositoryResponse
import com.challenge.magalu.data.server.ApiRequest
import io.reactivex.disposables.CompositeDisposable

class RepositoryDataSourceFactory(
    private val apiRequest: ApiRequest,
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, RepositoryResponse.Item>() {

    val newsDataSourceLiveData = MutableLiveData<RepositorySource>()

    override fun create(): DataSource<Int, RepositoryResponse.Item> {
        val newsDataSource = RepositorySource(apiRequest, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}