package uk.co.imobilize.lastfmsampleapp.utils

interface ConsoleLogger {
    /*Verbose statements used to find an issue*/
    fun debug(message: String)
    /*Useful log messages*/
    fun info(message: String)
    /*Serious, something that should not occur and needs to be looked into*/
    fun warning(message: String)
    /*Fatal, application may stop due to this error*/
    fun error(message: String)
}