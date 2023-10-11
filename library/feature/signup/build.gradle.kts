plugins {
    id("com.vhontar.android.library")
}

dependencies {
    implementation(project(":core:logger"))
    implementation(project(":domain:logger"))
    implementation(project(":feature:home")) // <-- wrong to do

    implementation(libs.androidx.appCompat)
}