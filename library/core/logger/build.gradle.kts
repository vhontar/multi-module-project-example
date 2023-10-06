plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.vhontar.core.logger"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain:logger"))
}