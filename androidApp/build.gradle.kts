plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-rc01")

    api("com.arcao:slf4j-timber:3.0")

    //Image downloader
    implementation("com.squareup.picasso:picasso:2.71828")

    implementation(Koin.core)
    implementation(Koin.android)
}

android {

    defaultConfig {
        applicationId = "uk.co.imobilize.lastfmsampleapp.android"

        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        compileSdk = AndroidSdk.compile

        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
    }
}