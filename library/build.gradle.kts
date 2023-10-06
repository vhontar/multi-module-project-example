buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.gradlePlugins.android)
        classpath(libs.gradlePlugins.kotlin)
    }
}

plugins {
    alias(libs.plugins.moduleGraphAssertion)
}

allprojects {
    version = "1.0.0"
}

moduleGraphAssert {
    maxHeight = 4
    allowed = arrayOf(
        ":.* -> :domain:.*",
        ":.* -> :core:.*",
    )
    restricted = arrayOf(
        ":core:.* -X> :feature",
        ":feature:.* -X> :feature:.*"
    )
    assertOnAnyBuild = false
}