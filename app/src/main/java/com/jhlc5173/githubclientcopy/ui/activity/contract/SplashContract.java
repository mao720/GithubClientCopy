package com.jhlc5173.githubclientcopy.ui.activity.contract;

import com.jhlc5173.githubclientcopy.data.model.User;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/6.
 */

public interface SplashContract {
    interface View {
        void showLoading(boolean loading);

        void showValidationError();

        void showRepositoriesListForUser(User user);

        void toast(Throwable e);
        //void showToast(String username);
    }
}
