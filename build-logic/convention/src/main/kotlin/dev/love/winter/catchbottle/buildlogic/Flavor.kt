package dev.love.winter.catchbottle.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import dev.love.winter.catchbottle.buildlogic.extension.androidExtension

internal fun Project.configureFlavor() {
    androidExtension.apply {
        buildTypes {
            maybeCreate("debug").apply {
                isMinifyEnabled = false
            }
            maybeCreate("release").apply {
                isMinifyEnabled = true
            }
        }
        sourceSets {
            getByName("debug") {
                kotlin.srcDirs("src/debug/kotlin")
                java.srcDirs("src/debug/java")
            }
            getByName("release") {
                kotlin.srcDirs("src/release/kotlin")
                java.srcDirs("src/release/java")
            }
        }
    }
}

class AndroidFlavorConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureFlavor()
        }
    }
}
