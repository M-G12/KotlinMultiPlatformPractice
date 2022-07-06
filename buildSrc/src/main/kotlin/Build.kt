object Build {
    private const val gradleBuildTools = "7.2.1"
    const val buildTools = "com.android.tools.build:gradle:${gradleBuildTools}"
    const val sqlDelightGradlePlugin = "com.squareup.sqldelight:gradle-plugin:${SQLDelight.sqlDelightVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
}