package com.jhlc5173.githubclientcopy.ui.activity.component;

import com.jhlc5173.githubclientcopy.ui.activity.ActivityScope;
import com.jhlc5173.githubclientcopy.ui.activity.RepositoryDetailsActivity;
import com.jhlc5173.githubclientcopy.ui.activity.module.RepositoryDetailsActivityModule;

import dagger.Subcomponent;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/20.
 */
@ActivityScope
@Subcomponent(modules = RepositoryDetailsActivityModule.class)
public interface RepositoryDetailsActivityComponent {
    void inject(RepositoryDetailsActivity repositoryDetailsActivity);
}
