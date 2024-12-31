package dev.love.winter.catchbottle.buildlogic

import dev.love.winter.catchbottle.buildlogic.extension.androidExtension
import dev.love.winter.catchbottle.buildlogic.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureCompose() {
    with(pluginManager) {
        apply("com.google.devtools.ksp")

        //compose compiler
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    val libs = extensions.libs
    androidExtension.apply {
        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose-compilerVersion").get().toString()
        }
        buildFeatures {
            compose = true
        }
    }

    dependencies {
        val bom = libs.findLibrary("compose-bom").get()
        "implementation"(platform(bom))
        "androidTestImplementation"(platform(bom))
        "implementation"(libs.findLibrary("compose-uiToolingPreview").get())
//        "implementation"(libs.findLibrary("compose-foundation").get())
//        "implementation"(libs.findLibrary("compose-runtime").get())
//        "implementation"(libs.findLibrary("compose-navigation").get())
//        "implementation"(libs.findLibrary("compose-material").get())
//        "implementation"(libs.findLibrary("compose-material3").get())
//        "implementation"(libs.findLibrary("compose-activity").get())
        "implementation"(libs.findLibrary("androidx-hilt-composeNavigation").get())
        "implementation"(libs.findLibrary("compose-keyboardState").get())
        "debugImplementation"(libs.findLibrary("compose-uiTooling").get())
    }
}

internal class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureCompose()
        }
    }
}
