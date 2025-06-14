plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "ru.nvgsoft.testeffectivemobile"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.nvgsoft.testeffectivemobile"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.navigation.compose)

    implementation(libs.androidx.runtime.livedata)
    //Gson
    implementation(libs.gson)


    //Coil
    implementation(libs.coil)
    //Coil compose
    implementation(libs.coil.compose)
    //Coil сеть
    implementation(libs.coil.network)

    //OkHttpClient
    implementation(libs.okHttpClient)
    //HttpLoggingInterceptor
    implementation(libs.httpLoggingInterceptor)

    //Retrofit
    implementation(libs.retrofit)

    //Dagger2
    implementation(libs.dagger2)
//Dagger2 кодогенератор
    ksp(libs.dagger2.compiler)
//Dagger2 аннотации
    ksp(libs.dagger2.android.processor)

    //Compose LiveData
    implementation(libs.compose.livedata)

    //Room
    implementation(libs.room)
    // Кодогенератор Room
    ksp(libs.room.compiler)
// optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.room.ktx)
    //ViewModel
    implementation(libs.viewModel)

}