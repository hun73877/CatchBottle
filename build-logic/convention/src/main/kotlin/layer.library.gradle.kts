import dev.love.winter.catchbottle.buildlogic.configureKotlinAndroid
import dev.love.winter.catchbottle.buildlogic.configureFlavor

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureFlavor()