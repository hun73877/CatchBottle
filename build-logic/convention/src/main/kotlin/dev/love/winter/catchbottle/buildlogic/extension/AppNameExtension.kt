package dev.love.winter.catchbottle.buildlogic.extension

import org.gradle.api.Project
import kotlin.apply

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "dev.love.winter.catchbottle.$name"
    }
}
