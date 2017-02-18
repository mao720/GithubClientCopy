package com.jhlc5173.githubclientcopy;

import android.app.Application;
import android.content.Context;

import com.jhlc5173.githubclientcopy.data.UserComponent;
import com.jhlc5173.githubclientcopy.data.api.UserModule;
import com.jhlc5173.githubclientcopy.data.model.User;

public class GithubClientApplication extends Application {

    private AppComponent appComponent;
    private UserComponent userComponent;

    public static GithubClientApplication get(Context context) {
        return (GithubClientApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {

        }
        initAppComponent();
    }

    public void initAppComponent() {
        //appModule() is deprecated
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        //appComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserComponent createUserComponent(User user) {
        userComponent = appComponent.plus(new UserModule(user));
        return userComponent;
    }

    public void releaseUserComponent() {
        userComponent = null;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
