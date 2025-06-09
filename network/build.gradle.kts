plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.secuedge.network"
    compileSdk = 34
    defaultConfig { minSdk = 33 }
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}
