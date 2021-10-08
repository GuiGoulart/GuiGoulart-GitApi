package com.challenge.magalu.data.server

import com.challenge.magalu.data.model.RepositoryPullsResponse
import com.challenge.magalu.data.model.RepositoryResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {

    @GET("search/repositories")
    fun searchRepository(
        @Query("q") q: String? = "language:Java",
        @Query("sort") sort: String? = "stars",
        @Query("page") page: Int? = 1,
        @Query("per_page") per_page: Int? = 20
    ): Single<RepositoryResponse>

    @GET("repos/{name}/{repository}/pulls")
    fun reposRepositoryPull(
        @Path("name") name: String?,
        @Path("repository") repository: String?
    ): Observable<List<RepositoryPullsResponse>>

}