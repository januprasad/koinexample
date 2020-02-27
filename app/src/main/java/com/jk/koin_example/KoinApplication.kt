package com.jk.koin_example

import android.app.Application
import com.jk.koin_example.fragment.fragmentModule
import com.jk.koin_example.fragment.viewModelModule
import com.jk.koin_example.network.networkModule
import com.jk.koin_example.repo.postOfficeRepo
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KoinApplication)
            modules(listOf(fragmentModule,
                viewModelModule,
                networkModule ,
                postOfficeRepo))
        }
    }
}