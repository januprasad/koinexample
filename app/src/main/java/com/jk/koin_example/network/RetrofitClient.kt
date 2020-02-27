package com.jk.koin_example.network

import com.jk.koin_example.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    factory {
        provideLoggingInterceptor()
    }

    factory {
        provideOkHttpClient(get())
    }

    single {
        provideRetrofitClient(get())
    }

    factory {
        providePostOfficeApi(get())
    }

    factory {
        ResponseHandler()
    }
}

fun providePostOfficeApi(retrofit: Retrofit): PostOfficeApi = retrofit.create(PostOfficeApi::class.java)


fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit = Retrofit
    .Builder()
    .baseUrl(BuildConfig.API_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient()
    .newBuilder()
    .addInterceptor(loggingInterceptor)
    .build()

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BODY
    return logger
}

