import dev.love.winter.catchbottle.buildlogic.configureAndroid
import dev.love.winter.catchbottle.buildlogic.configureAndroidTest
import dev.love.winter.catchbottle.buildlogic.configureCoroutineAndroid
import dev.love.winter.catchbottle.buildlogic.configureFlavor
import dev.love.winter.catchbottle.buildlogic.configureHiltAndroid
import dev.love.winter.catchbottle.buildlogic.configureUnitTest

plugins {
    id("com.android.application")
}

configureAndroid()
configureCoroutineAndroid()
configureHiltAndroid()
configureFlavor()
configureUnitTest()
configureAndroidTest()

android {
    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {

    add("implementation", libs.findLibrary("android-material").get())
    add("implementation", libs.findLibrary("androidx-appCompat").get())
    add("implementation", libs.findLibrary("androidx-core").get())
    add("implementation", libs.findLibrary("androidx-splashScreen").get())
    add("implementation", libs.findLibrary("androidx-lifecycle-viewModel").get())
    add("implementation", libs.findLibrary("androidx-workerManager").get())

    add("implementation", libs.findLibrary("kotlin-serializationJson").get())
    add("implementation", libs.findLibrary("androidx-splashScreen").get())

}