plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.secuedge.edgeai"
    compileSdk = 34
    defaultConfig { minSdk = 33 }
}

dependencies {
    implementation("org.tensorflow:tflite-task-vision:0.5.4")
}
