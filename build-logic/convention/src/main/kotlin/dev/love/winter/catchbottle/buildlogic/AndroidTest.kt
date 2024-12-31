package dev.love.winter.catchbottle.buildlogic

import dev.love.winter.catchbottle.buildlogic.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


internal fun Project.configureAndroidTest() {
    val libs = extensions.libs
    dependencies {
        "androidTestImplementation"(libs.findLibrary("test-androidx-core").get())
        "androidTestImplementation"(libs.findLibrary("test-androidx-runner").get())
    }
}

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureAndroidTest()
        }
    }
}
