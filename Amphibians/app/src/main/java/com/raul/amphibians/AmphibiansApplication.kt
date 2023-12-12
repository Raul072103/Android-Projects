package com.raul.amphibians

import android.app.Application
import com.raul.amphibians.data.AppContainer
import com.raul.amphibians.data.DefaultAppContainer

class AmphibiansApplication: Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}