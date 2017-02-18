package com.jhlc5173.githubclientcopy.data.api;

import com.google.gson.Gson;
import com.jhlc5173.githubclientcopy.data.api.response.UserResponse;
import com.jhlc5173.githubclientcopy.data.model.User;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Description:
 * Created by MaoJunFeng on 2017/2/7.
 */

public class UserManager {
    private GithubApiService githubApiService;

    public UserManager(GithubApiService githubApiService) {
        this.githubApiService = githubApiService;
    }

    public Observable<User> getUser(String username) {
        return githubApiService.getUser(username)
                .map(new Func1<UserResponse, User>() {
                    @Override
                    public User call(UserResponse userResponse) {
                        User user = new User();
                        user.login = userResponse.login;
                        user.id = userResponse.id;
                        user.url = userResponse.url;
                        user.email = userResponse.email;
                        return user;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<User> upLoadFile() {
        final File file = new File("data/data/com.jhlc5173.githubclientcopy/files/test.jpg");
//        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        RequestBody image = RequestBody.create(MediaType.parse("image/jpg"), file);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("files", "",RequestBody.create(MultipartBody.FORM, file))
                .build();
        return githubApiService.updateAvatar(requestBody)
                .map(new Func1<UserResponse, User>() {
                    @Override
                    public User call(UserResponse userResponse) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /*public Observable<UserResponse> testLogin() {
        return githubApiService.testLogin("1","15888980682","2456",1487406787L,"77b87e7feb835b4a5617cddd42d26c73")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }*/
    public Observable<UserResponse> testLogin() {
        Gson gson=new Gson();
        HashMap<String,String> paramsMap=new HashMap<>();
        paramsMap.put("device","1");
        paramsMap.put("phone","15888980682");
        paramsMap.put("verifyCode","2456");
        paramsMap.put("timestamp","1487406787");
        paramsMap.put("sign","77b87e7feb835b4a5617cddd42d26c73");
        String strEntity = gson.toJson(paramsMap);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

        //Call<BaseResponse> call = api.getService().createCommit(body);
        return githubApiService.testLogin(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
