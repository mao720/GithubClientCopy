package com.jhlc5173.githubclientcopy.ui.activity.component;

import com.jhlc5173.githubclientcopy.ui.activity.ActivityScope;
import com.jhlc5173.githubclientcopy.ui.activity.SplashActivity;
import com.jhlc5173.githubclientcopy.ui.activity.module.SplashActivityModule;

import dagger.Subcomponent;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/6.
 */
@ActivityScope
@Subcomponent(modules = SplashActivityModule.class)
public interface SplashActivityComponent {
    SplashActivity inject(SplashActivity splashActivity);
}
