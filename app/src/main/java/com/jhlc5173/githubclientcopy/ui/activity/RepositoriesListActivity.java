package com.jhlc5173.githubclientcopy.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.common.collect.ImmutableList;
import com.jhlc5173.githubclientcopy.GithubClientApplication;
import com.jhlc5173.githubclientcopy.R;
import com.jhlc5173.githubclientcopy.data.model.Repository;
import com.jhlc5173.githubclientcopy.ui.activity.contract.RepositoriesListContract;
import com.jhlc5173.githubclientcopy.ui.activity.module.RepositoriesListActivityModule;
import com.jhlc5173.githubclientcopy.ui.activity.presenter.RepositoriesListActivityPresenter;
import com.jhlc5173.githubclientcopy.ui.adapter.RepositoriesListAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/11.
 */
public class RepositoriesListActivity extends BaseActivity implements RepositoriesListContract.View {
    @BindView(R.id.rvRepositories)
    RecyclerView rvRepositories;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;
    @Inject
    LinearLayoutManager linearLayoutManager;
    @Inject
    RepositoriesListAdapter repositoriesListAdapter;
    @Inject
    RepositoriesListActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories_list);
        ButterKnife.bind(this);
        setupRepositoriesListView();
        presenter.loadRepositories();
    }

    private void setupRepositoriesListView() {
        rvRepositories.setLayoutManager(linearLayoutManager);
        rvRepositories.setAdapter(repositoriesListAdapter);
    }

    @Override
    protected void setupActivityCompontent() {
        GithubClientApplication.get(this)
                .getUserComponent()
                .plus(new RepositoriesListActivityModule(this))
                .inject(this);
    }

    public void showLoading(boolean isLoading) {
        pbLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        rvRepositories.setVisibility(isLoading ? View.GONE : View.VISIBLE);
    }

    public void setRepositories(ImmutableList<Repository> repositories) {
        repositoriesListAdapter.updateRepositoriesList(repositories);
    }
}
