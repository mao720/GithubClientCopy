package com.jhlc5173.githubclientcopy.ui.activity.presenter;

import com.google.common.collect.ImmutableList;
import com.jhlc5173.githubclientcopy.data.api.RepositoriesManager;
import com.jhlc5173.githubclientcopy.data.model.Repository;
import com.jhlc5173.githubclientcopy.ui.activity.RepositoriesListActivity;

import rx.Subscriber;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/16.
 */
public class RepositoriesListActivityPresenter {

    private RepositoriesManager repositoriesManager;
    private RepositoriesListActivity repositoriesListActivity;

    public RepositoriesListActivityPresenter(RepositoriesListActivity repositoriesListActivity, RepositoriesManager repositoriesManager) {
        this.repositoriesListActivity = repositoriesListActivity;
        this.repositoriesManager = repositoriesManager;
    }

    public void loadRepositories() {
        repositoriesManager.getUserRepositores()
                .subscribe(new Subscriber<ImmutableList<Repository>>() {
                    @Override
                    public void onStart() {
                        repositoriesListActivity.showLoading(true);
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        repositoriesListActivity.showLoading(false);
                    }

                    @Override
                    public void onNext(ImmutableList<Repository> repositories) {
                        repositoriesListActivity.setRepositories(repositories);
                        repositoriesListActivity.showLoading(false);
                    }
                });
    }
}
