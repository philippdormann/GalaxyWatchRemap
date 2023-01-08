import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.devtools.ksp").version("1.6.21-1.0.6")
}

val properties = gradleLocalProperties(rootDir)

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "de.philippdormann.galaxywatchremap"
        minSdk = 30
        targetSdk = 33
        versionCode = 200
        versionName = "2.0.0"

    }

    signingConfigs {
        create("release") {
            storeType = properties.getProperty("signing.release.storeType", "PKCS12")
            storeFile = rootDir.resolve(properties.getProperty("signing.release.storeFile", "keystore.p12"))
            storePassword = properties.getProperty("signing.release.storePassword", "")
            keyAlias = properties.getProperty("signing.release.keyAlias", "")
            keyPassword = properties.getProperty("signing.release.keyPassword", "")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs["release"]
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("com.google.android.gms:play-services-wearable:18.0.0")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.wear:wear:1.2.0")
    implementation("androidx.percentlayout:percentlayout:1.0.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.activity:activity-ktx:1.6.1")
    implementation("androidx.fragment:fragment-ktx:1.5.5")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0") {
        exclude("org.jetbrains.kotlin", "kotlin-reflect ")
    }
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")
}