package com.jhlc5173.githubclientcopy.data.api;

import com.jhlc5173.githubclientcopy.data.UserScope;
import com.jhlc5173.githubclientcopy.data.api.GithubApiService;
import com.jhlc5173.githubclientcopy.data.api.RepositoriesManager;
import com.jhlc5173.githubclientcopy.data.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/7.
 */
@Module
public class UserModule {
    private User user;

    public UserModule(User user) {
        this.user = user;
    }

    /*@Provides
    @UserScope
    User provideUser() {
        return user;
    }*/
    @Provides
    @UserScope
    RepositoriesManager provideRepositoriesManager(GithubApiService githubApiService) {
        return new RepositoriesManager(user ,githubApiService);
    }
}

