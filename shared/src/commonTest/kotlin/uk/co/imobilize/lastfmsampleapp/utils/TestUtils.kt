package com.indexlabs.kmm_frontend.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.job


@Suppress("SuspendFunctionOnCoroutineScope")
suspend fun CoroutineScope.joinChildren() = coroutineContext.job.children.forEach { it.join() }
