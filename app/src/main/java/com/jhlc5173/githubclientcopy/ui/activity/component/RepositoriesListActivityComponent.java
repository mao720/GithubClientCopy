package com.jhlc5173.githubclientcopy.ui.activity.component;

import com.jhlc5173.githubclientcopy.ui.activity.ActivityScope;
import com.jhlc5173.githubclientcopy.ui.activity.RepositoriesListActivity;
import com.jhlc5173.githubclientcopy.ui.activity.module.RepositoriesListActivityModule;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/13.
 */
@ActivityScope
@Subcomponent(modules = RepositoriesListActivityModule.class)
public interface RepositoriesListActivityComponent {
    void inject(RepositoriesListActivity repositoriesListActivity);
}
