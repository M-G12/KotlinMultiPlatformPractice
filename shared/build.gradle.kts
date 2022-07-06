import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.7.0"
    id("com.squareup.sqldelight")
}

version = "1.0"

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosAppKk/Podfile")
    }
    
    sourceSets {
        val ktorVersion = "2.0.3"
        val commonMain by  getting {
            dependencies {
                implementation(Kotlinx.datetime)
                implementation(SQLDelight.runtime)
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")

            }
        }
        val androidMain by getting {
            dependencies {
                implementation(SQLDelight.androidDriver)
                implementation("io.ktor:ktor-client-android:$ktorVersion")
            }

        }
        val iosMain by getting {
            dependencies {
                implementation(SQLDelight.nativeDriver)
                implementation("io.ktor:ktor-client-ios:${ktorVersion}")
        }
        }
    }
}
sqldelight {
    database("RecipeDatabase") {
        packageName = "com.gharibe.kk.android.datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}
android {
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    namespace = "com.example.kk"
}