package uk.co.imobilize.lastfmsampleapp.di

import co.touchlab.kermit.Kermit
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import uk.co.imobilize.lastfmsampleapp.services.http.KtorHttpServiceImpl
import uk.co.imobilize.lastfmsampleapp.utils.ConsoleLogger
import uk.co.imobilize.lastfmsampleapp.utils.KermitConsoleLogger
import kotlin.native.concurrent.ThreadLocal

// called by iOS etc
fun initKoin() = initKoin(enableNetworkLogs = false) {}

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()

        modules(
            commonModule(enableNetworkLogs = enableNetworkLogs),
        )
    }


fun commonModule(enableNetworkLogs: Boolean) = module {
    single { JsonBuilder }
    single { createHttpClient(get(), enableNetworkLogs = enableNetworkLogs) }
    single { Kermit(logger = get()) }
    single<ConsoleLogger> { KermitConsoleLogger(get()) }
    single {
        KtorHttpServiceImpl(get()).jsonRequestBuilder()
    }

}

@ThreadLocal
val JsonBuilder = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

fun createHttpClient(json: Json, enableNetworkLogs: Boolean) = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer(json)
    }
    if (enableNetworkLogs) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
    }
}
