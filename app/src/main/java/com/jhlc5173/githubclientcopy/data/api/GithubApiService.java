package com.jhlc5173.githubclientcopy.data.api;

import com.jhlc5173.githubclientcopy.data.api.response.RepositoresResponse;
import com.jhlc5173.githubclientcopy.data.api.response.UserResponse;
import com.jhlc5173.githubclientcopy.data.model.User;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/7.
 */

public interface GithubApiService {
    @GET("/users/{username}")
    Observable<UserResponse> getUser(@Path("username") String username);
    @Multipart
    @POST("common/file/upload.do")
    Observable<UserResponse> updateAvatar (@Part("files\"; filename=\"test.jpg") RequestBody imgs );

    @GET("/users/{username}/repos")
    Observable<List<RepositoresResponse>> getUserRepositories(@Path("username") String username);
    /*@FormUrlEncoded
    @POST("/mobile-user-service/account/app/login")
    Observable<UserResponse> testLogin(@Field("device") String device,
                                       @Field("phone") String phone,
                                       @Field("verifyCode") String verifyCode,
                                       @Field("timestamp") Long timestamp,
                                       @Field("sign") String sign);*/
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/mobile-user-service/account/app/login")
    Observable<UserResponse> testLogin(@Body RequestBody body);
}
