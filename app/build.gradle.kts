@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.bzlzhh.plugin.ngg"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.manus.kryptonr9i"
        minSdk = 26
        targetSdk = 34
        versionCode = 6
        versionName = "R9i 0.1.4-brutal-3"

        manifestPlaceholders["des"] = "Krypton Wrapper R9i Performance (OpenGL 3.1+)"
        manifestPlaceholders["renderer"] = "NGGL4ES:libng_gl4es.so:libEGL.so"
        manifestPlaceholders["boatEnv"] = mutableMapOf<String, String>().apply {
            put("LIBGL_USE_MC_COLOR", "1")
            put("LIBGL_GL", "31")
            put("LIBGL_ES", "3")
            put("LIBGL_NORMALIZE", "1")
            put("LIBGL_NOERROR", "1")
            // Brutal optimization: Downscale all textures by half to save VRAM bandwidth.
            put("LIBGL_SHRINK", "1")
            // CPU/GPU Sync optimization: Disable VSync to uncap frames.
            put("LIBGL_VSYNC", "0")
            // Memory optimization: Recycle Framebuffer Objects to reduce allocation overhead.
            put("LIBGL_RECYCLEFBO", "1")
        }.run {
            var env = ""
            forEach { (key, value) ->
                env += "$key=$value:"
            }
            env.dropLast(1)
        }
        manifestPlaceholders["pojavEnv"] =
            manifestPlaceholders["boatEnv"] as String +
                    (mutableMapOf<String, String>().apply {
                        put("POJAV_RENDERER", "opengles3")
                    }.run {
                        var env = ":"
                        forEach { (key, value) ->
                            env += "$key=$value:"
                        }
                        env.dropLast(1)
                    })

        buildConfigField("boolean", "useANGLE", "false")
        buildConfigField("String", "deviceProfile", "\"realme_9i_brutal_3\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
        configureEach {
            resValue("string", "app_name", "Krypton Wrapper R9i")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("io.noties.markwon:core:4.6.2")
    implementation("io.noties.markwon:ext-strikethrough:4.6.2")
    implementation(project(":NGG"))
}
