package com.jhlc5173.githubclientcopy.ui.activity.presenter;

import com.jhlc5173.githubclientcopy.data.model.User;
import com.jhlc5173.githubclientcopy.ui.activity.RepositoryDetailsActivity;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/20.
 */
public class RepositoryDetailsActivityPresenter {

    private User user;
    private RepositoryDetailsActivity repositoryDetailsActivity;

    public RepositoryDetailsActivityPresenter(RepositoryDetailsActivity repositoryDetailsActivity, User user) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
        this.user = user;
    }

    public void initView() {
        repositoryDetailsActivity.setUsername(user.login);
    }
}
