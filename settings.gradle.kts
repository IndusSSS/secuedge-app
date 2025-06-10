pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "secuedge-app"

include(
    ":app",
    ":core",
    ":network",
    ":data",
    ":domain",
    ":edgeai",
    ":hotspot",
    ":tests"
)
