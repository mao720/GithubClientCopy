package com.jhlc5173.githubclientcopy.ui.activity.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.jhlc5173.githubclientcopy.data.api.UserManager;
import com.jhlc5173.githubclientcopy.data.api.response.UserResponse;
import com.jhlc5173.githubclientcopy.data.model.User;
import com.jhlc5173.githubclientcopy.ui.activity.contract.SplashContract;
import com.jhlc5173.githubclientcopy.utils.Validator;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/4.
 */

public class SplashActivityPresenter {

    public String username;
    private SplashContract.View view;
    private Validator validator;
    private UserManager userManager;

    public SplashActivityPresenter(SplashContract.View view, Validator validator, UserManager userManager) {
        this.view = view;
        this.validator = validator;
        this.userManager = userManager;
    }

    public void onShowRepositoriesClick() {
        /*//上传图片
        userManager.upLoadFile().subscribe(new SimpleObserver<User>(){
            @Override
            public void onNext(User user) {
                view.toast(null);
                super.onNext(user);
            }

            @Override
            public void onError(Throwable e) {
                view.toast(null);
                super.onError(e);
            }
        });*/
        /*userManager.testLogin().subscribe(new Subscriber<UserResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.toast(e);
            }

            @Override
            public void onNext(UserResponse userResponse) {
                view.toast(null);
            }
        });*/
        if (validator.validUsername(username)) {
            //view.showLoading(true);
            userManager.getUser(username)
//                    .subscribeOn(Schedulers.io())
//                    .doOnSubscribe(new Action0() {
//                        @Override
//                        public void call() {
//                            view.showLoading(true);
//                            Toast.makeText((Activity)view, Thread.currentThread().toString(), Toast.LENGTH_SHORT).show();
//
//                        }
//                    })
                    .subscribe(new Subscriber<User>() {
                @Override
                public void onNext(User user) {
                    view.showLoading(false);
                    view.showRepositoriesListForUser(user);
                }

                @Override
                public void onCompleted() {}

                @Override
                public void onStart() {
                    Toast.makeText((Activity)view, Thread.currentThread().toString(), Toast.LENGTH_SHORT).show();

                    view.showLoading(true);
                }

                @Override
                public void onError(Throwable e) {
                    view.showLoading(false);
                    view.showValidationError();
                    view.toast(e);
                }
            });
        } else {
            view.showValidationError();
        }
    }

   /* public void toast() {
        splashActivity.showToast(username);
    }*/
}
