
plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.2")
    implementation ("com.makeramen:roundedimageview:2.3.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.github.zcweng:switch-button:0.0.3@aar")

    val nav_version = "2.3.5"

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")


}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "br.com.unifimes.coopermin.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}