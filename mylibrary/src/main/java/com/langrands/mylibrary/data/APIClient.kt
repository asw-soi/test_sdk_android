package com.langrands.mylibrary.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.os.Build

class APIClient {
    private val loggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val requestInterceptor =
        Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("X-Spacer-ExApp-Token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlLZXlJZCI6InA0Tmwwa1NhY1hWbnRlbUhnWk1hSFpyMXAyMlhSVExmaDNtYjd5TSIsInVzZXJJZCI6Ii1NX2NWNzY0Q2RwaUVCdTVQRW40IiwiaWF0IjoxNjI5MzQ5NDQwLCJleHAiOjE2Mjk5NTQyNDB9.QBibwqr9jSvxPgzw5V8cPGMmI2c3NVjMgTgBznm-tz8")
                .addHeader("User-Agent", userAgent)
                .build()
            return@Interceptor chain.proceed(request)
        }

    private val userAgent: String
        get() {
            return String.format(
                "SPACER/%s (kotlin %s; %s; %s)",
                Build.VERSION.RELEASE,
                Build.MODEL,
                Build.BRAND,
                Build.DEVICE
            )
        }

    private val httpBuilder = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .addInterceptor(loggingInterceptor)


    private val retrofit = Retrofit.Builder()
//            .baseUrl("https://api-vsv0ukl18tz6dm.spacer.co.jp")
        .baseUrl("http://120.143.1.101:8008")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpBuilder.build())
        .build()


    val locker: ILockerAPI by lazy { retrofit.create(ILockerAPI::class.java) }
}

val api = APIClient()