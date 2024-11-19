
import jm.compile.setupLibraryModule

plugins {
    id("com.android.library")
    id("kotlin-android")
}

setupLibraryModule(name = "jm.droid.lib.connector")


dependencies {
    api("com.google.guava:guava:30.1-android")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.9.0")

    implementation("com.google.guava:listenablefuture:1.0")
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}