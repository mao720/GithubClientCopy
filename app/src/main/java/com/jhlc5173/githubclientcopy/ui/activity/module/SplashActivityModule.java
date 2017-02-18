package com.jhlc5173.githubclientcopy.ui.activity.module;

import com.jhlc5173.githubclientcopy.data.api.UserManager;
import com.jhlc5173.githubclientcopy.ui.activity.ActivityScope;
import com.jhlc5173.githubclientcopy.ui.activity.SplashActivity;
import com.jhlc5173.githubclientcopy.ui.activity.contract.SplashContract;
import com.jhlc5173.githubclientcopy.ui.activity.presenter.SplashActivityPresenter;
import com.jhlc5173.githubclientcopy.utils.Validator;

import dagger.Module;
import dagger.Provides;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/6.
 */
@Module
public class SplashActivityModule {
    private SplashContract.View view;

    public SplashActivityModule(SplashContract.View view) {
        this.view = view;
    }

/*    @Provides
    @ActivityScope
    SplashActivity provideSplashActivity() {
        return new SplashActivity();
    }*/

    @Provides
    @ActivityScope
    SplashActivityPresenter provideSplashActivityPresenter(Validator validator, UserManager userManager) {
        return new SplashActivityPresenter(view, validator, userManager);
    }
}
