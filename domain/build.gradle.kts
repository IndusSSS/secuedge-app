plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.secuedge.domain"
    compileSdk = 34
    defaultConfig { minSdk = 33 }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}
