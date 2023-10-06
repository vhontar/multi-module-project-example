plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.vhontar.feature.login"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation(project(":core:logger"))
    implementation(project(":domain:logger"))
    implementation(project(":feature:home")) // <-- wrong to do

    implementation(libs.androidx.appCompat)
}