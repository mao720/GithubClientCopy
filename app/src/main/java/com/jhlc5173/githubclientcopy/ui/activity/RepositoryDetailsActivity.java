package com.jhlc5173.githubclientcopy.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jhlc5173.githubclientcopy.GithubClientApplication;
import com.jhlc5173.githubclientcopy.R;
import com.jhlc5173.githubclientcopy.data.model.Repository;
import com.jhlc5173.githubclientcopy.ui.activity.module.RepositoryDetailsActivityModule;
import com.jhlc5173.githubclientcopy.ui.activity.presenter.RepositoryDetailsActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/20.
 */
public class RepositoryDetailsActivity extends BaseActivity {
    @BindView(R.id.tvRepoName)
    TextView tvRepoName;
    @BindView(R.id.tvRepoDetails)
    TextView tvRepoDetails;
    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @Inject
    RepositoryDetailsActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Repository repository = getIntent().getParcelableExtra(RepositoriesListActivity.ARG_REPOSITORY);
        tvRepoName.setText(repository.name);
        tvRepoDetails.setText(repository.url);
        presenter.initView();
    }

    @Override
    protected void setupActivityCompontent() {
        GithubClientApplication.get(this).getUserComponent()
                .plus(new RepositoryDetailsActivityModule(this))
                .inject(this);
    }

    public void setUsername(String login) {
        tvUserName.setText(login);
    }
}
