plugins {
    id("com.android.library")
    id("maven-publish")
    kotlin("android")
}
@kotlin.Suppress("SpellCheckingInspection")
android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdk = 21
        targetSdk = 30
        version = "0.8"

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions { jvmTarget = "1.8" }

    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>("release") {
                    pom {
                        name.set("ktAnim")
                        description.set("A Simple & Configurable Android View-Animations Library")

                        developers {
                            developer {
                                id.set("bsandeep")
                                name.set("Sandeep Bhutiya")
                            }
                        }
                    }

                    groupId = "com.sandeepbhutiya.ktanim"
                    artifactId = "final"
                    version = "0.8"

                    from(components["release"])
                }
            }
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.6.0")
}