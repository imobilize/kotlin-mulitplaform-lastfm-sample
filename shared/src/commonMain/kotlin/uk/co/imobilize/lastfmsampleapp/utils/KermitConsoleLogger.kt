package uk.co.imobilize.lastfmsampleapp.utils

import co.touchlab.kermit.Kermit

class KermitConsoleLogger(private val logger: Kermit): ConsoleLogger {

    override fun debug(message: String) {
        logger.d { message }
    }

    override fun info(message: String) {
        logger.i { message }
    }

    override fun warning(message: String) {
        logger.w { message }
    }

    override fun error(message: String) {
        logger.e { message }
    }
}