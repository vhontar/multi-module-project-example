package com.vhontar.gradle.plugins

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class AndroidApplicationPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.android.application")
        extensions.configure<ApplicationExtension>("android") { ext ->
            with(ext) {
                compileSdk = AndroidVersions.compileSdk
                namespace = "com.vhontar.${gradleProjectPathToNamespace(path)}"
                defaultConfig {
                    minSdk = AndroidVersions.minSdk
                    vectorDrawables.useSupportLibrary = true
                    versionCode = 1
                    versionName = "1.0"

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                buildTypes.named("release").configure {
                    it.proguardFiles(getDefaultProguardFile("proguard-android.txt"))
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.3"
                }
                buildFeatures.viewBinding = true
                buildFeatures.compose = true

                packaging.resources.excludes.add("META-INF/DEPENDENCIES")
            }
        }
    }
}