plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.secuedge.tests"
    compileSdk = 34
    defaultConfig {
        minSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation(project(":data"))
    implementation("androidx.room:room-testing:2.6.1")
}
