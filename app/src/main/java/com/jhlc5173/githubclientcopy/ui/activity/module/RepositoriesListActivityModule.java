package com.jhlc5173.githubclientcopy.ui.activity.module;

import android.support.v7.widget.LinearLayoutManager;

import com.jhlc5173.githubclientcopy.data.api.RepositoriesManager;
import com.jhlc5173.githubclientcopy.data.model.Repository;
import com.jhlc5173.githubclientcopy.ui.activity.ActivityScope;
import com.jhlc5173.githubclientcopy.ui.activity.RepositoriesListActivity;
import com.jhlc5173.githubclientcopy.ui.activity.presenter.RepositoriesListActivityPresenter;
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
 * Created by MaoJunFeng on 2017/2/13.
 */
@Module
public class RepositoriesListActivityModule {
    private RepositoriesListActivity repositoriesListActivity;

    public RepositoriesListActivityModule(RepositoriesListActivity repositoriesListActivity) {
        this.repositoriesListActivity = repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivityPresenter provideRepositoriesListActivityPresenter(RepositoriesManager repositoriesManager) {
        return new RepositoriesListActivityPresenter(repositoriesListActivity, repositoriesManager);
    }

/*    @Provides
    @ActivityScope
    RepositoriesListActivity provideRepositoriesListActivity() {
        return repositoriesListActivity;
    }*/

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(repositoriesListActivity);
    }

    @Provides
    @ActivityScope
    RepositoriesListAdapter provideRepositoriesListAdapter(Map<Integer, RepositoriesViewHolderFactory> viewHolderFactories) {
        return new RepositoriesListAdapter(repositoriesListActivity, viewHolderFactories);
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_NORMAL)
    RepositoriesViewHolderFactory provideViewHolderNormal() {
        return new RepositoriesViewHolderNormalFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_BIG)
    RepositoriesViewHolderFactory provideViewHolderBig() {
        return new RepositoriesViewHolderBigFactory();
    }
}
