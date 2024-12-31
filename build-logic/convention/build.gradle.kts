import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

group = "dev.love.winter.catchbottle.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.kotlin.serializationJson)
    implementation(libs.android.gradlePlugin)
    implementation(libs.compose.compilerGradlePlugin)
}

gradlePlugin {
    plugins {
//        register("catchBottleAndroid") {
//            id = "catchbottle.android"
//            implementationClass = "${group}.AndroidLibraryConventionPlugin"
//        }
//        register("androidHilt") {
//            id = "catchbottle.hiltconvention"
//            implementationClass = "${group}.AndroidHiltConventionPlugin"
//        }
    }
}
