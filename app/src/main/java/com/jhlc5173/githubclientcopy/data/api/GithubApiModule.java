package com.jhlc5173.githubclientcopy.data.api;

import android.app.Application;

import com.jhlc5173.githubclientcopy.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/7.
 */
@Module
public class GithubApiModule {
    @Singleton
    @Provides
    OkHttpClient providesOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 100, TimeUnit.MILLISECONDS);
        return builder.build();
    }
    @Singleton
    @Provides
    Retrofit providesRestAdapter(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl("https://api.github.com")
                //.baseUrl("http://172.16.76.111:80")
                //.baseUrl("http://mn.5173.cn/api/")
                //.baseUrl("http://120.27.237.114:8081/b2b2c/rest/api/v1/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }
    @Singleton
    @Provides
    GithubApiService providesGithubApiService(Retrofit restAdapter) {
        return restAdapter.create(GithubApiService.class);
    }
    @Singleton
    @Provides
    UserManager providesUserManager(GithubApiService githubApiService) {
        return new UserManager(githubApiService);
    }
}
