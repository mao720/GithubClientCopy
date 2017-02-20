package com.jhlc5173.githubclientcopy.ui.activity.module;

import android.support.v7.widget.LinearLayoutManager;

import com.jhlc5173.githubclientcopy.data.api.RepositoriesManager;
import com.jhlc5173.githubclientcopy.data.model.Repository;
import com.jhlc5173.githubclientcopy.data.model.User;
import com.jhlc5173.githubclientcopy.ui.activity.ActivityScope;
import com.jhlc5173.githubclientcopy.ui.activity.RepositoriesListActivity;
import com.jhlc5173.githubclientcopy.ui.activity.RepositoryDetailsActivity;
import com.jhlc5173.githubclientcopy.ui.activity.presenter.RepositoriesListActivityPresenter;
import com.jhlc5173.githubclientcopy.ui.activity.presenter.RepositoryDetailsActivityPresenter;
import com.jhlc5173.githubclientcopy.ui.adapter.RepositoriesListAdapter;
import com.jhlc5173.githubclientcopy.ui.adapter.viewholder.RepositoriesViewHolderBigFactory;
import com.jhlc5173.githubclientcopy.ui.adapter.viewholder.RepositoriesViewHolderFactory;
import com.jhlc5173.githubclientcopy.ui.adapter.viewholder.RepositoriesViewHolderNormalFactory;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/20.
 */
@Module
public class RepositoryDetailsActivityModule {

    private RepositoryDetailsActivity repositoryDetailsActivity;

    public RepositoryDetailsActivityModule(RepositoryDetailsActivity repositoryDetailsActivity) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivityPresenter provideRepositoryDetailsActivityPresenter(User user) {
        return new RepositoryDetailsActivityPresenter(repositoryDetailsActivity, user);
    }
}
