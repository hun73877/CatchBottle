import dev.love.winter.catchbottle.buildlogic.configureAndroid
import dev.love.winter.catchbottle.buildlogic.configureHiltAndroid
import dev.love.winter.catchbottle.buildlogic.configureCompose
import dev.love.winter.catchbottle.buildlogic.configureAndroidTest

plugins {
    id("com.android.library")
}

configureAndroid()
configureHiltAndroid()
configureCompose()
configureAndroidTest()