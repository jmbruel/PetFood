package com.mexator.petfoodinspector

import android.app.Application
import com.mexator.petfoodinspector.data.local.LocalRepository

/**
 * Yes, I use Application as DI provider
 */
class AppController : Application() {
    override fun onCreate() {
        super.onCreate()
        LocalRepository.provideAppContext(applicationContext)
    }
}