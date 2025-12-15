import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import dev.architectury.plugin.ArchitectPluginExtension
import net.fabricmc.loom.api.LoomGradleExtensionAPI
import net.fabricmc.loom.task.RemapJarTask

plugins {
    java
    id("maven-publish")
    id("com.teamresourceful.resourcefulgradle") version "0.0.+"
    id("dev.architectury.loom") version "1.4-SNAPSHOT" apply false
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
}

architectury {
    val minecraftVersion: String by project
    minecraft = minecraftVersion
}

subprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "dev.architectury.loom")
    apply(plugin = "architectury-plugin")
    apply(plugin = "com.github.johnrengelman.shadow")

    val minecraftVersion: String by project
    val modLoader = project.name
    val modId = rootProject.name
    val isCommon = modLoader == rootProject.projects.common.name

    base {
        archivesName.set("$modId-$modLoader-$minecraftVersion")
    }

    configure<LoomGradleExtensionAPI> {
        silentMojangMappingsLicense()
    }

    repositories {
        mavenCentral()
        maven(url = "https://maven.architectury.dev/")
        maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
        maven(url = "https://maven.firstdarkdev.xyz/snapshots")
        maven(url = "https://maven.createmod.net")

        maven {
            url = uri("https://www.cursemaven.com")
            content {
                includeGroup("curse.maven")
            }
        }
        exclusiveContent {
            forRepository {
                maven {
                    name = "Modrinth"
                    url = uri("https://api.modrinth.com/maven")
                }
            }
            filter {
                includeGroup("maven.modrinth")
            }
        }
    }

    dependencies {
        val mixinExtrasVersion: String by project
        val resourcefulLibVersion: String by project
        val resourcefulConfigVersion: String by project
        val botariumVersion: String by project
        val adAstraVersion: String by project
        val jeiVersion: String by project
        val reiVersion: String by project
        val patchouliVersion: String by project
        val athenaVersion: String by project

        "minecraft"("::$minecraftVersion")

        @Suppress("UnstableApiUsage")
        "mappings"(project.the<LoomGradleExtensionAPI>().layered {
            val parchmentVersion: String by project
            officialMojangMappings()
            parchment(create(group = "org.parchmentmc.data", name = "parchment-$minecraftVersion", version = parchmentVersion))
        })

        "modApi"(group = "com.teamresourceful.resourcefullib", name = "resourcefullib-$modLoader-$minecraftVersion", version = resourcefulLibVersion)
        "modApi"(group = "com.teamresourceful.resourcefulconfig", name = "resourcefulconfig-$modLoader-$minecraftVersion", version = resourcefulConfigVersion)
        "modApi"(group = "earth.terrarium.botarium", name = "botarium-$modLoader-$minecraftVersion", version = botariumVersion)
        "modCompileOnly"(group = "earth.terrarium.adastra", name = "ad_astra-$modLoader-$minecraftVersion", version = adAstraVersion)

        if (isCommon) {
            "modApi"(group = "mezz.jei", name = "jei-$minecraftVersion-common-api", version = jeiVersion)
            "modCompileOnly"(group = "me.shedaniel", name = "RoughlyEnoughItems-api", version = reiVersion)
            "modCompileOnly"(group = "me.shedaniel", name = "RoughlyEnoughItems-default-plugin", version = reiVersion)
            implementation("annotationProcessor"(group = "io.github.llamalad7", name = "mixinextras-common", version = mixinExtrasVersion))
        } else {
            "modCompileOnly"(group = "me.shedaniel", name = "RoughlyEnoughItems-api-$modLoader", version = reiVersion)
            "modCompileOnly"(group = "me.shedaniel", name = "RoughlyEnoughItems-default-plugin-$modLoader", version = reiVersion)
            "modLocalRuntime"(group = "vazkii.patchouli", name = "Patchouli", version = "$minecraftVersion-$patchouliVersion-${modLoader.uppercase()}")
            "modLocalRuntime"(group = "earth.terrarium.athena", name = "athena-$modLoader-$minecraftVersion", version = athenaVersion)
        }
    }

    java {
        withSourcesJar()
        toolchain.languageVersion = JavaLanguageVersion.of(17)
    }


    tasks.jar {
        archiveClassifier.set("dev")
    }

    tasks.named<RemapJarTask>("remapJar") {
        archiveClassifier.set(null as String?)
    }

    tasks.processResources {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        filesMatching(listOf("META-INF/mods.toml", "fabric.mod.json")) {
            expand("version" to project.version)
        }
    }

    if (!isCommon) {
        configure<ArchitectPluginExtension> {
            platformSetupLoomIde()
        }

        val shadowCommon by configurations.creating {
            isCanBeConsumed = false
            isCanBeResolved = true
        }

        tasks {
            named<ShadowJar>("shadowJar") {
                archiveClassifier.set("dev-shadow")
                configurations = listOf(shadowCommon)

                exclude(".cache/**")
                exclude("com/nekomu/adxero/datagen/**")
            }

            named<RemapJarTask>("remapJar") {
                val shadowJarTask = named<ShadowJar>("shadowJar").get()
                dependsOn(shadowJarTask)
                inputFile.set(shadowJarTask.archiveFile)
                archiveClassifier.set(null as String?)
            }
        }
    } else {
        sourceSets.main.get().resources.srcDirs("src/main/generated/resources")
    }
}