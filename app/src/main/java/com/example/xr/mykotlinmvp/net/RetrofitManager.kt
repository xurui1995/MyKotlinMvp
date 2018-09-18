package com.example.xr.mykotlinmvp.net

import com.example.xr.mykotlinmvp.MyApplication
import com.example.xr.mykotlinmvp.api.ApiService
import com.example.xr.mykotlinmvp.api.UrlConstant
import com.example.xr.mykotlinmvp.util.AppUtils
import com.example.xr.mykotlinmvp.util.PreferenceUtils
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object RetrofitManager {

    val service: ApiService by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        getRetrofit().create(ApiService::class.java)
    }

    private var token:String by PreferenceUtils("token", "")

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(UrlConstant.BASE_URL)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val cacheFile = File(MyApplication.context.cacheDir, "cache")
        val cache = Cache(cacheFile, 1024 * 1024 * 50)

        return OkHttpClient.Builder()
                .addInterceptor(addQueryParameterInterceptor())
                .addInterceptor(addHeaderInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
    }

    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor {
            chain ->
            val originalRequest = chain.request()
            val modifiedUrl = originalRequest.url().newBuilder()
                    .addQueryParameter("udid", "d2807c895f0348a180148c9dfa6f2feeac0781b5")
                    .addQueryParameter("deviceModel", AppUtils.getMobileModel())
                    .build()
            chain.proceed(originalRequest.newBuilder().url(modifiedUrl).build())
        }
    }

    private fun addHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val requestBuilder = originalRequest.newBuilder()
                    // Provide your custom header here
                    .header("token", token)
                    .method(originalRequest.method(), originalRequest.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }
}