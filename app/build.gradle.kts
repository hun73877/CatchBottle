plugins {
    id("layer.application")
    id("catchbottle.compose")
    id("catchbottle.retrofit")
    id("catchbottle.firebase")
    id("catchbottle.room")
    alias(libs.plugins.kotlinSerialization)
}

android {
    namespace = "dev.love.winter.catchbottle"

    defaultConfig {
        applicationId = "dev.love.winter.catchbottle"
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = "${libs.versions.major.get()}.${libs.versions.minor.get()}.${libs.versions.hotfix.get()}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
    ksp {
        arg("room.incremental", "true")
        arg("room.generateKotlin", "true")
    }
}

dependencies {

//    implementation(project(":core:common"))
//    implementation(project(":core:design:core_design_resource"))
//    implementation(project(":core:design:designsystem"))
//    implementation(project(":core:design:compose"))
//    implementation(project(":core:design:ui"))
//    implementation(project(":core:data:model:user"))
//    implementation(project(":core:data:model:liquor"))
//    implementation(project(":core:data:repository"))
//    implementation(project(":core:domain"))
//    implementation(project(":core:network:firebase:firestore"))
//    implementation(project(":core:network:firebase:storage"))
//    implementation(project(":core:network:firebase:remoteconfig"))
////    implementation(project(":features:screen:main_navigation_contents"))
//    implementation(project(":features:screen:login"))
//    implementation(project(":features:screen:main"))

    implementation(libs.kotlin.serializationJson)

    annotationProcessor(libs.glideAnnotationProcessor)
    implementation(libs.glide)
}