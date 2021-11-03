@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform") version "1.5.31"
    id("com.android.library")
}

group = "com.mipo"
version = "0.1"

repositories {
    google()
    mavenCentral()
}

kotlin {
    android()

    linuxX64()
    macosX64()
    iosX64()
    iosArm64()
    iosArm32()
    androidNativeArm64()
    androidNativeArm32()

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)

            dependencies {

            }
        }
        val androidTest by getting {
            dependsOn(commonTest)

            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }

        val nativeMain by creating {
            dependsOn(commonMain)
        }

        val linuxX64Main by getting {
            dependsOn(nativeMain)
        }

        val macosX64Main by getting {
            dependsOn(nativeMain)
        }

        val iosX64Main by getting {
            dependsOn(nativeMain)
        }

        val iosArm64Main by getting {
            dependsOn(nativeMain)
        }

        val iosArm32Main by getting {
            dependsOn(nativeMain)
        }

        val androidNativeArm64Main by getting {
            dependsOn(nativeMain)
        }

        val androidNativeArm32Main by getting {
            dependsOn(nativeMain)
        }
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(31)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}