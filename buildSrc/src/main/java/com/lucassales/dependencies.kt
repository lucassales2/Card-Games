package com.lucassales

object Versions {
    const val ktlint = "0.31.0"
}

object Modules {
    const val app = ":app"
    const val arch = ":arch"
    const val core = ":core"
    const val solitaire = ":solitaire"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:3.5.1"

    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val junit = "junit:junit:4.12"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
    const val ribbonizer = "com.github.gfx.ribbonizer:ribbonizer-plugin:2.1.0"
    const val exifinterface = "com.android.support:exifinterface:28.0.0"
    const val swipelayout = "com.daimajia.swipelayout:library:1.2.0@aar"
    const val hockeySDK = "net.hockeyapp.android:HockeySDK:5.1.1"
    const val eventbus = "org.greenrobot:eventbus:3.1.1"
    const val fastscroll = "com.l4digital.fastscroll:fastscroll:2.0.1"
    const val materialedittext = "com.rengwuxian.materialedittext:library:2.1.4"
    const val circularProgressBar = "com.mikhaellopez:circularprogressbar:2.0.0"
    const val persistentCookieJar = "com.github.franmontiel:PersistentCookieJar:1.0.1"
    const val gson = "com.google.code.gson:gson:2.8.5"
    const val multidex = "com.android.support:multidex:1.0.3"
    const val injex = "javax.inject:javax.inject:1"

    object Google {
        const val material = "com.google.android.material:material:1.1.0-alpha02"
        const val zxingCore = "com.google.zxing:core:3.3.3"
    }

    object Kotlin {
        private const val version = "1.3.21"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Coroutines {
        private const val version = "1.1.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.0.2"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"
        const val cardview = "androidx.cardview:cardview:1.0.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-alpha3"

        object Lifecycle {

            private const val version = "2.0.0"
            const val runtime = "androidx.lifecycle:lifecycle-runtime:$version"
            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
        }
    }

    object RxJava {
        const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.7"
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.3.0"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }

    object Dagger {
        private const val version = "2.22.1"
        val dagger = "com.google.dagger:dagger:$version"
        val androidSupport = "com.google.dagger:dagger-android-support:$version"
        val compiler = "com.google.dagger:dagger-compiler:$version"
        val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object Glide {
        private const val version = "4.9.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Retrofit {
        private const val version = "2.5.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val scalarsConverter = "com.squareup.retrofit2:converter-scalars:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "3.12.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Epoxy {
        private const val version = "3.4.0"
        val epoxy = "com.airbnb.android:epoxy:$version"
        val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
        val processor = "com.airbnb.android:epoxy-processor:$version"
    }

    object Test {

        const val mockk = "io.mockk:mockk:1.9.1"
        const val runner = "androidx.test:runner:1.1.1"
        const val okhttp = "com.github.gmazzo:okhttp-mock:1.2.1"
        const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
        const val assertjCore = "org.assertj:assertj-core:3.12.1"
        const val junit = Libs.junit

        object PowerMock {
            const val core = "org.powermock:powermock-api-mockito2:2.0.0"
            const val module = "org.powermock:powermock-module-junit4:2.0.0"
        }

        object Expresso {
            private const val version = "3.1.1"
            const val core = "androidx.test.espresso:espresso-core:$version"
            const val intent = "androidx.test.espresso:espresso-intents:$version"
            const val contrib = "androidx.test.espresso:espresso-contrib:$version"
        }

        object Mockito {
            private const val version = "2.24.5"
            const val core = "org.mockito:mockito-core:$version"
            const val android = "org.mockito:mockito-android:$version"
        }
    }
}
