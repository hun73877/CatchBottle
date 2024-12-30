import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.androidApp)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidHilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.googleServicesGms)
}

android {
    namespace = "com.season.winter.catchbottle"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.season.winter.catchbottle"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
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
    dataBinding {
        enable = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:design:core_design_resource"))
    implementation(project(":core:design:designsystem"))
    implementation(project(":core:design:compose"))
    implementation(project(":core:design:ui"))
    implementation(project(":core:data:model:user"))
    implementation(project(":core:data:model:liquor"))
    implementation(project(":core:data:repository"))
    implementation(project(":core:domain"))
    implementation(project(":core:network:firebase:firestore"))
    implementation(project(":core:network:firebase:storage"))
    implementation(project(":core:network:firebase:remoteconfig"))
//    implementation(project(":features:screen:main_navigation_contents"))
    implementation(project(":features:screen:login"))
    implementation(project(":features:screen:main"))

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

    libs.test.run {
        testImplementation(androidx.core)
        testImplementation(androidx.runner)
        testImplementation(libs.junit)
        testImplementation(junit5)
        testImplementation(junit5.engine)
        testImplementation(mockito.kotlin)
        testImplementation(mockWebserver)
        testImplementation(coroutines)
        testImplementation(coroutines.turbine)
    }

}

fun getApiKey(property: String): String {
    return gradleLocalProperties(rootDir).getProperty(property) ?: ""
}