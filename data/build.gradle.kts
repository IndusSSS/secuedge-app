plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.smartsecurity.secuedge.data"
    compileSdk = 35
    defaultConfig { minSdk = 29 }
}

dependencies {
    // TODO: Room and coroutine dependencies
}
