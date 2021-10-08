package com.challenge.magalu.data.paging

import androidx.paging.PageKeyedDataSource
import com.challenge.magalu.data.model.RepositoryResponse
import com.challenge.magalu.data.server.ApiRequest
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action

class RepositorySource(
    private val apiRequest: ApiRequest,
    private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Int, RepositoryResponse.Item>() {

    private var retryCompletable: Completable? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, RepositoryResponse.Item>
    ) {
        apiRequest.services?.searchRepository(
            q = "language:Java",
            sort = "stars",
            page = 1,
            per_page = 10
        )?.let {
            compositeDisposable.add(
                it.subscribe(
                    { response ->
                        callback.onResult(
                            response.items,
                            null,
                            2
                        )
                    }
                ) {
                    setRetry { loadInitial(params, callback) }
                }
            )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, RepositoryResponse.Item>) {
        apiRequest.services?.searchRepository(
            q = "language:Java",
            sort = "stars",
            page = params.key,
            per_page = 10
        )?.let {
            compositeDisposable.add(
                it.subscribe(
                    { response ->
                        callback.onResult(
                            response.items,
                            params.key - 1
                        )
                    }
                ) {
                    setRetry { loadAfter(params, callback) }
                }
            )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, RepositoryResponse.Item>) {
        apiRequest.services?.searchRepository(
            q = "language:Java",
            sort = "stars",
            page = params.key,
            per_page = 10
        )?.let {
            compositeDisposable.add(
                it.subscribe(
                    { response ->
                        callback.onResult(
                            response.items,
                            params.key - 1
                        )
                    }
                ) {
                    setRetry { loadAfter(params, callback) }
                }
            )
        }
    }

    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }

}