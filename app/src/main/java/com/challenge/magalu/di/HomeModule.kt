package com.challenge.magalu.di

import com.challenge.magalu.data.server.ApiRequest
import com.challenge.magalu.ui.viewModel.DetailsViewModel
import com.challenge.magalu.ui.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

private val loadFeature by lazy { loadKoinModules(homeModule) }
internal fun injectFeature() = loadFeature

val homeModule = module {

    //Request
    single { ApiRequest() }

    //viewmodel
    viewModel { HomeViewModel(apiRequest = get()) }
    viewModel { DetailsViewModel(apiRequest = get()) }
}