
object Versions {
    const val kotlin = "1.5.20"
    const val kotlinCoroutines = "1.5.0-native-mt"
    const val ktor = "1.6.0"
    const val kotlinxSerialization = "1.2.2"
    const val koin = "3.1.0"
    const val kermit = "0.1.9"
    const val slf4j = "1.7.30"
    const val junit = "4.13.2"
    const val testRunner = "1.3.0"
}


object AndroidSdk {
    const val min = 21
    const val compile = 30
    const val target = compile
}

object Deps {
    const val kermit = "co.touchlab:kermit:${Versions.kermit}"
}

object Test {
    const val junit = "junit:junit:${Versions.junit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
}

object Koin {
    val core = "io.insert-koin:koin-core:${Versions.koin}"
    val test = "io.insert-koin:koin-test:${Versions.koin}"
    val android = "io.insert-koin:koin-android:${Versions.koin}"
}

object Ktor {
    val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
    val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"

    val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    val slf4j = "org.slf4j:slf4j-simple:${Versions.slf4j}"
    val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
    val clientCio = "io.ktor:ktor-client-cio:${Versions.ktor}"
}

object Serialization {
    val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
}
