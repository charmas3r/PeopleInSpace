pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

}

rootProject.name = "workout"

include(":app", ":common", ":compose-desktop")
include(":web")
include(":compose-web")
include(":backend")
