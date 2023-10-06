plugins {
    id("com.vhontar.android.library")
}

dependencies {
    implementation(project(":core:logger"))
    implementation(project(":domain:logger"))

    implementation(libs.androidx.appCompat)
}