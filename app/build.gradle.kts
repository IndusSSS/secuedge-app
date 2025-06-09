plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.smartsecurity.secuedge"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.smartsecurity.secuedge"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "0.1"
    }
    buildFeatures { }
}

dependencies {
    // TODO: CameraX dependencies
    // TODO: WebRTC dependency
    // TODO: LiteRT / ML Kit
}
