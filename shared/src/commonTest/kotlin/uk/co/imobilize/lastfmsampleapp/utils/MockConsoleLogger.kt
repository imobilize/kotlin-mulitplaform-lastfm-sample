package uk.co.imobilize.lastfmsampleapp.utils

class MockConsoleLogger: ConsoleLogger {

    override fun debug(message: String) {}

    override fun info(message: String) {}

    override fun warning(message: String) {}

    override fun error(message: String) {}
}
