package dev.love.winter.catchbottle.buildlogic

import dev.love.winter.catchbottle.buildlogic.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureRetrofit() {
    with(pluginManager) {
        apply("dagger.hilt.android.plugin")
        apply("com.google.devtools.ksp")
    }

    val libs = extensions.libs

    //    implementation(libs.gson)
    //    implementation(libs.network.okhttp)
    //    implementation(libs.network.okhttp.logging)
    //    implementation(libs.network.retrofit)
    //    implementation(libs.network.retrofit.converter.gson)
    //    implementation(libs.network.retrofit.converter.kotlinxSerialization)
    dependencies {
        "implementation"(libs.findLibrary("network-okhttp").get())
        "implementation"(libs.findLibrary("network-okhttp-logging").get())
        "implementation"(libs.findLibrary("network-retrofit").get())
        "implementation"(libs.findLibrary("network-retrofit-converter-gson").get())
        "implementation"(libs.findLibrary("network-retrofit-converter-kotlinxSerialization").get())
    }
}

internal class AndroidRetrofitConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureRetrofit()
        }
    }
}
