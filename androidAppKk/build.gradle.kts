plugins {
    id("com.android.application")
    kotlin("android")
    kotlin(KotlinPlugins.kapt)
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
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(Compose.ui)
    implementation(Compose.navigation)
    implementation(Compose.material)
}