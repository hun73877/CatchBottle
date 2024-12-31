import dev.love.winter.catchbottle.buildlogic.configureKotlinAndroid
import dev.love.winter.catchbottle.buildlogic.configureHiltAndroid
import dev.love.winter.catchbottle.buildlogic.configureCompose
import dev.love.winter.catchbottle.buildlogic.configureAndroidTest

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureHiltAndroid()
configureCompose()
configureAndroidTest()