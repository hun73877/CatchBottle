//import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.androidApp)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidHilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.googleServicesGms)
    alias(libs.plugins.composeCompiler)
}

android {
    namespace = "dev.love.winter.catchbottle"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "dev.love.winter.catchbottle"
        minSdk = libs.versions.minSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = "${libs.versions.major.get()}.${libs.versions.minor.get()}.${libs.versions.hotfix.get()}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
    buildFeatures {
        compose = true
        buildConfig = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compilerVersion.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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

    implementation(libs.kotlin)
    implementation(libs.kotlin.serializationJson)
    implementation(libs.coroutines.android)

    implementation(libs.android.material)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.core)

    implementation(libs.androidx.splashScreen)
    implementation(libs.androidx.lifecycle.viewModel)
    implementation(libs.androidx.recyclerView)
    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.workerManager)

    implementation(libs.androidx.hilt.android)
    ksp(libs.androidx.hilt.android.compiler)

    implementation(libs.androidx.room)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    implementation(libs.gson)
    implementation(libs.network.okhttp)
    implementation(libs.network.okhttp.logging)
    implementation(libs.network.retrofit)
    implementation(libs.network.retrofit.converter.gson)
    implementation(libs.network.retrofit.converter.kotlinxSerialization)

    implementation(libs.compose.activity)
    implementation(libs.compose.ui)
    implementation(libs.compose.navigation)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.runtime)

    implementation(libs.compose.keyboardState)
    implementation(libs.compose.uiToolingPreview)
    implementation(libs.androidx.lifecycleRuntimeCompose)
    implementation(libs.androidx.hilt.navigation.compose)

    compileOnly(libs.compose.compilerGradlePlugin)

    debugRuntimeOnly(libs.compose.uiTooling)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.fireStore)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.remoteConfig)

    annotationProcessor(libs.glideAnnotationProcessor)
    implementation(libs.glide)

    implementation(libs.test.mockito.kotlin)
    implementation(libs.test.mockWebserver)

    testImplementation(libs.test.androidx.core)
    testImplementation(libs.test.androidx.runner)
    testImplementation(libs.test.junit)
    testImplementation(libs.test.junit5)
    testImplementation(libs.test.junit5.engine)
    testImplementation(libs.test.mockito.kotlin)
    testImplementation(libs.test.mockWebserver)
    testImplementation(libs.test.coroutines)
    testImplementation(libs.test.coroutines.turbine)
}

//fun getApiKey(property: String): String {
//    return gradleLocalProperties(rootDir).getProperty(property) ?: ""
//}