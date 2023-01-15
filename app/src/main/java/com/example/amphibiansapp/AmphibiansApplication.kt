package com.example.amphibiansapp

import android.app.Application
import com.example.amphibiansapp.data.AmphibianAppContainer
import com.example.amphibiansapp.data.RepositoryAppContainer

class AmphibiansApplication : Application() {
    lateinit var container: AmphibianAppContainer
    override fun onCreate() {
        super.onCreate()
        container = RepositoryAppContainer()
    }
}