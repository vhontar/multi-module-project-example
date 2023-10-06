plugins {
    kotlin("jvm") version "1.9.10"
    `java-gradle-plugin`
}

repositories {
    gradlePluginPortal()
    google()
}

dependencies {
    implementation(libs.gradlePlugins.android)
    implementation(libs.gradlePlugins.kotlin)
}

gradlePlugin {
    plugins {
        register("androidLibraryPlugin") {
            id = "com.vhontar.android.library"
            implementationClass = "com.vhontar.gradle.plugins.AndroidLibraryPlugin"
        }
        register("androidApplicationPlugin") {
            id = "com.vhontar.android.application"
            implementationClass = "com.vhontar.gradle.plugins.AndroidApplicationPlugin"
        }
    }
}