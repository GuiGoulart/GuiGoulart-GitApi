package com.challenge.magalu.ui.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.challenge.magalu.data.model.RepositoryPullsResponse
import com.challenge.magalu.data.server.ApiRequest
import com.challenge.magalu.ui.listener.DetailsViewModelListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsViewModel(val apiRequest: ApiRequest) : ViewModel() {

    @SuppressLint("CheckResult")
    fun getReposRepositoryPull(name: String, repository: String, detailsViewModelListener: DetailsViewModelListener) {
        val reposRepositoryPullResponse = mutableListOf<RepositoryPullsResponse>()
        apiRequest.services?.reposRepositoryPull(name, repository)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ repositoryPull ->
                repositoryPull?.map {
                    reposRepositoryPullResponse.add(it)
                }
            }, { e ->
                e.printStackTrace()
                reposRepositoryPullResponse.clear()
                detailsViewModelListener.errorListRepository()
            }, {
                detailsViewModelListener.completListRepository(reposRepositoryPullResponse)
            })
    }

}