package dev.love.winter.catchbottle.buildlogic

import dev.love.winter.catchbottle.buildlogic.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureFirebase() {
    with(pluginManager) {
        apply("com.google.gms.google-services")
    }

    val libs = extensions.libs
    dependencies {
        val bom = libs.findLibrary("firebase-bom").get()
        "implementation"(platform(bom))
        "implementation"(libs.findLibrary("firebase-bom").get())
        "implementation"(libs.findLibrary("firebase-analytics").get())
        "implementation"(libs.findLibrary("firebase-fireStore").get())
        "implementation"(libs.findLibrary("firebase-storage").get())
        "implementation"(libs.findLibrary("firebase-remoteConfig").get())
    }
}

internal class AndroidFirebaseConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureHiltAndroid()
        }
    }
}
