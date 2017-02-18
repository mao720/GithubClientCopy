package com.jhlc5173.githubclientcopy;

import com.jhlc5173.githubclientcopy.data.UserComponent;
import com.jhlc5173.githubclientcopy.data.api.UserModule;
import com.jhlc5173.githubclientcopy.data.api.GithubApiModule;
import com.jhlc5173.githubclientcopy.ui.activity.component.SplashActivityComponent;
import com.jhlc5173.githubclientcopy.ui.activity.module.SplashActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/6.
 */
@Singleton
@Component(modules = {AppModule.class, GithubApiModule.class})
public interface AppComponent {
    SplashActivityComponent plus(SplashActivityModule module);

    UserComponent plus(UserModule module);
}
