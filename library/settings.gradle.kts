pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

include(
    ":core:logger"
)

include(
    ":domain:logger"
)

include(
    ":feature:login",
    ":feature:signup",
    ":feature:home",
)

includeBuild("../gradle-plugins")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
    }
}
