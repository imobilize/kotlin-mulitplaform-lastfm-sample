package uk.co.imobilize.lastfmsampleapp.di

import co.touchlab.kermit.LogcatLogger
import co.touchlab.kermit.Logger
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<Logger>{ LogcatLogger() }
}
