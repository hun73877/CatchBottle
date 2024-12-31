package dev.love.winter.catchbottle.buildlogic

import dev.love.winter.catchbottle.buildlogic.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureRoomAndroid() {
    with(pluginManager) {
        apply("androidx.room")
        apply("com.google.devtools.ksp")
    }

    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("androidx-room-runtime").get())
        "implementation"(libs.findLibrary("androidx-room").get())
        "ksp"(libs.findLibrary("androidx-room-compiler").get())
    }
}

internal class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureRoomAndroid()
        }
    }
}
