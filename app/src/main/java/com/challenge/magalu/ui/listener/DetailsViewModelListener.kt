package com.challenge.magalu.ui.listener

import com.challenge.magalu.data.model.RepositoryPullsResponse

interface DetailsViewModelListener {
    fun completListRepository(listItem: List<RepositoryPullsResponse>)
    fun errorListRepository()
}