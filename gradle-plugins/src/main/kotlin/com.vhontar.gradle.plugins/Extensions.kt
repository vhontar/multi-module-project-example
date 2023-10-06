package com.vhontar.gradle.plugins

import com.android.build.api.dsl.CompileOptions
import com.android.build.api.dsl.ComposeOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension

internal fun gradleProjectPathToNamespace(gradleProjectPath: String) =
    gradleProjectPath.drop(1).replace(":", ".").replace("-", ".")

internal fun CompileOptions.setup(project: Project) {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

internal fun ComposeOptions.setup(project: Project) {
    val versionCatalogsExtension = project.extensions.getByType(VersionCatalogsExtension::class.java)
    kotlinCompilerExtensionVersion = versionCatalogsExtension
        .named("libs")
        .findLibrary("tooling-composeCompiler")
        .get()
        .get()
        .versionConstraint
        .requiredVersion
}
