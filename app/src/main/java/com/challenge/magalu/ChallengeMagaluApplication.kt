package com.challenge.magalu

import android.app.Application
import com.challenge.magalu.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

val mainModules = listOf(homeModule)

class ChallengeMagaluApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ChallengeMagaluApplication)
            modules(mainModules)
        }
    }

}