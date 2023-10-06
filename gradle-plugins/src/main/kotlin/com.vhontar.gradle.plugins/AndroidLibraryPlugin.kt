package com.vhontar.gradle.plugins

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class AndroidLibraryPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.android.library")
        extensions.configure<LibraryExtension>("android") { ext ->
            with(ext) {
                compileSdk = AndroidVersions.compileSdk
                namespace = "com.vhontar.${gradleProjectPathToNamespace(path)}"
                defaultConfig {
                    minSdk = AndroidVersions.minSdk
                    vectorDrawables.useSupportLibrary = true
                }
                buildTypes.configureEach {
                    it.consumerProguardFiles("proguard-rules.pro")
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                buildFeatures.viewBinding = true
            }
        }
    }
}