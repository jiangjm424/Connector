// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    
    alias(libs.plugins.binaryCompatibility)
    alias(libs.plugins.dokka)
    alias(libs.plugins.spotless)
}

extensions.configure<ApiValidationExtension> {
    ignoredProjects += listOf("app")
}

tasks.withType<DokkaMultiModuleTask>().configureEach {
    outputDirectory by layout.projectDirectory.dir("docs/api")
}

allprojects {

    // Necessary to publish to Maven.
    group = groupId
    version = versionName

//    val configureTopLevelExtension: KotlinTopLevelExtension.() -> Unit = {
//        jvmToolchain(11)
//    }
//    plugins.withId("org.jetbrains.kotlin.android") {
//        configure<KotlinAndroidProjectExtension>(configureTopLevelExtension)
//    }
//    plugins.withId("org.jetbrains.kotlin.jvm") {
//        configure<KotlinJvmProjectExtension>(configureTopLevelExtension)
//    }

    tasks.withType<DokkaTaskPartial>().configureEach {
        dokkaSourceSets.configureEach {
            jdkVersion by 8
            failOnWarning by true
            skipDeprecated by true
            suppressInheritedMembers by true

            externalDocumentationLink {
                url by URL("https://developer.android.com/reference/")
            }
            externalDocumentationLink {
                url by URL("https://kotlinlang.org/api/kotlinx.coroutines/")
            }
            externalDocumentationLink {
                url by URL("https://square.github.io/okhttp/4.x/")
                packageListUrl by URL("https://colinwhite.me/okhttp3-package-list") // https://github.com/square/okhttp/issues/7338
            }
            externalDocumentationLink {
                url by URL("https://square.github.io/okio/3.x/okio/")
                packageListUrl by URL("https://square.github.io/okio/3.x/okio/okio/package-list")
            }
        }
    }

    dependencies {
        modules {
            module("org.jetbrains.kotlin:kotlin-stdlib-jdk7") {
                replacedBy("org.jetbrains.kotlin:kotlin-stdlib")
            }
            module("org.jetbrains.kotlin:kotlin-stdlib-jdk8") {
                replacedBy("org.jetbrains.kotlin:kotlin-stdlib")
            }
        }
    }

    // Uninstall test APKs after running instrumentation tests.
    tasks.whenTaskAdded {
        if (name == "connectedDebugAndroidTest") {
            finalizedBy("uninstallDebugAndroidTest")
        }
    }

    apply(plugin = "com.diffplug.spotless")

    val configureSpotless: SpotlessExtension.() -> Unit = {
        kotlin {
            target("**/*.kt")
            ktlint(libs.ktlint.get().version)
            endWithNewline()
            indentWithSpaces()
            trimTrailingWhitespace()
            licenseHeaderFile(rootProject.file("spotless/copyright.kt"))
        }
        format("kts") {
            target("**/*.kts")
            targetExclude("**/build/**/*.kts")
            endWithNewline()
            indentWithSpaces()
            trimTrailingWhitespace()
            // Look for the first line that doesn't have a block comment (assumed to be the license)
            licenseHeaderFile(rootProject.file("spotless/copyright.kts"), "(^(?![\\/ ]\\*).*$)")
        }
        format("xml") {
            target("**/*.xml")
            targetExclude("**/build/**/*.xml")
            endWithNewline()
            indentWithSpaces()
            trimTrailingWhitespace()
            // Look for the first XML tag that isn't a comment (<!--) or the xml declaration (<?xml)
            licenseHeaderFile(rootProject.file("spotless/copyright.xml"), "(<[^!?])")
        }
    }

    if (project === rootProject) {
        spotless { predeclareDeps() }
        extensions.configure<SpotlessExtensionPredeclare>(configureSpotless)
    } else {
        extensions.configure(configureSpotless)
    }
}
