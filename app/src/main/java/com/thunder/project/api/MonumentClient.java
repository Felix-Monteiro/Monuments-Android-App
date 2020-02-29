/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                             -
 - Last modified 3/17/19 5:24 AM                                              -                       -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.api;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MonumentClient {


    private static final String BASE_URL = "https://project-4a153.firebaseio.com";

    public static Retrofit getMonumentClient() {

        return new Retrofit.Builder().baseUrl(BASE_URL).client(provideOkHttp()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    private static Interceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private static OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(provideLoggingInterceptor())
                .build();
    }
}
