plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.secuedge.hotspot"
    compileSdk = 34
    defaultConfig { minSdk = 33 }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
}
