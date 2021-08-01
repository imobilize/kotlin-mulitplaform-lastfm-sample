package uk.co.imobilize.lastfmsampleapp.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.job
import kotlin.coroutines.CoroutineContext

expect fun runTest(block: suspend CoroutineScope.()-> Unit)

expect val testCoroutineContext: CoroutineContext
