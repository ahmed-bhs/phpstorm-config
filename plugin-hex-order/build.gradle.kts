plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
    id("org.jetbrains.intellij") version "1.17.4"
}

group = "com.ahmedbhs"
version = "1.0.0"

repositories {
    mavenCentral()
}

intellij {
    version.set("2025.2")
    type.set("PS")
    plugins.set(listOf("com.jetbrains.php"))
}

tasks {
    patchPluginXml {
        sinceBuild.set("252")
        untilBuild.set("252.*")
    }
    buildSearchableOptions {
        enabled = false
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
}
