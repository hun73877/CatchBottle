import dev.love.winter.catchbottle.buildlogic.configureHiltAndroid
import dev.love.winter.catchbottle.buildlogic.configureUnitTest

plugins {
    id("com.android.library")
}

configureHiltAndroid()
configureUnitTest()