plugins {
    id("com.android.application")
    kotlin("android")
    kotlin(KotlinPlugins.kapt)
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.7.0"

}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.kk.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
        viewBinding = true

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"

    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
    namespace = "com.example.kk.android"
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/release")
        }
        maven {
            url = uri("https://repository.jboss.org/maven2")
        }
    }
}

dependencies {
    val ktorVersion = "2.0.3"

    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(Compose.ui)
    implementation(Compose.navigation)
    implementation(Compose.material)
    implementation(Kotlinx.datetime)
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.google.dagger:hilt-android:2.42")
    kapt("com.google.dagger:hilt-android-compiler:2.42")
    implementation("io.ktor:ktor-client-android:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")
}