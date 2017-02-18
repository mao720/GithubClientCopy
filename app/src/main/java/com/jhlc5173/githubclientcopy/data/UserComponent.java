package com.jhlc5173.githubclientcopy.data;

import com.jhlc5173.githubclientcopy.data.api.UserModule;
import com.jhlc5173.githubclientcopy.ui.activity.component.RepositoriesListActivityComponent;
import com.jhlc5173.githubclientcopy.ui.activity.module.RepositoriesListActivityModule;

import dagger.Subcomponent;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/7.
 */
@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {
    RepositoriesListActivityComponent plus(RepositoriesListActivityModule module);
}
