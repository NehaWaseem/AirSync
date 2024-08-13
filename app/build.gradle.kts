plugins {

    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.fly"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fly"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.material3.android)
    //implementation(libs.androidx.room.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

//   implementation(libs.androidx.lifecycle.extensions.ktx)
    implementation(libs.rxjava)
    implementation(libs.rxandroid)

    kapt(libs.kotlinx.metadata.jvm)
    implementation(libs.javapoet)
//      implementation(libs.hilt.android.v248)
//      kapt(libs.hilt.android.compiler.v248)

    implementation(libs.androidx.lifecycle.livedata.ktx.v261)
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v270)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.core.ktx.v1101)
    kapt(libs.com.google.dagger.hilt.compiler2)
    implementation(libs.kotlinx.coroutines.core)
    //implementation (libs.androidx.lifecycle.viewmodel.ktx.v260)


    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)

//    kapt(libs.androidx.lifecycle.common.java8)
//    implementation(libs.androidx.lifecycle.viewmodel.ktx.v220)
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx)

    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)

    //implementation(libs.androidx.room)

    implementation (libs.androidx.recyclerview.v131)
}
kapt {
     correctErrorTypes = true
}