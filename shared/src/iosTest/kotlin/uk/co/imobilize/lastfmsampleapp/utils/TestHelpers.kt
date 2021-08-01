package uk.co.imobilize.lastfmsampleapp.utils

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

actual fun runTest(block: suspend CoroutineScope.()-> Unit) =
    runBlocking(testCoroutineContext) {
        block()
    }

actual val testCoroutineContext: CoroutineContext = GlobalScope.coroutineContext

//actual val testCoroutineContext: CoroutineContext = newSingleThreadContext("testRunner")
