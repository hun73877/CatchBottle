package dev.love.winter.catchbottle.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import dev.love.winter.catchbottle.buildlogic.extension.libs
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureUnitTest() {
    val libs = extensions.libs
    dependencies {
        "testImplementation"(libs.findLibrary("test-junit").get())
        "testImplementation"(libs.findLibrary("test-junit5").get())
        "testImplementation"(libs.findLibrary("test-junit5-engine").get())
        "testImplementation"(libs.findLibrary("test-mockito-kotlin").get())
    }
}


class AndroidUnitTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureUnitTest()
        }
    }
}
