package dev.love.winter.catchbottle.buildlogic

import dev.love.winter.catchbottle.buildlogic.extension.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCoroutineAndroid() {
    configureCoroutineKotlin()
    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("coroutines-android").get())
    }
}

private fun Project.configureCoroutineKotlin() {
    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("coroutines-core").get())
        "testImplementation"(libs.findLibrary("test-coroutines").get())
        "testImplementation"(libs.findLibrary("test-coroutines-turbine").get())
    }
}
