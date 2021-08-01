package uk.co.imobilize.lastfmsampleapp.utils

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

actual fun runTest(block: suspend CoroutineScope.()-> Unit) =
    runBlocking(testCoroutineContext) {
        block()
    }

actual val testCoroutineContext: CoroutineContext =
    Executors.newSingleThreadExecutor().asCoroutineDispatcher()
