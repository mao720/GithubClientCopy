package com.jhlc5173.githubclientcopy.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;
import com.jhlc5173.githubclientcopy.GithubClientApplication;
import com.jhlc5173.githubclientcopy.R;
import com.jhlc5173.githubclientcopy.data.model.User;
import com.jhlc5173.githubclientcopy.ui.activity.contract.SplashContract;
import com.jhlc5173.githubclientcopy.ui.activity.module.SplashActivityModule;
import com.jhlc5173.githubclientcopy.ui.activity.presenter.SplashActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/4.
 */

public class SplashActivity extends BaseActivity implements SplashContract.View{
    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.btnShowRepositories)
    Button btnShowRepositories;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;
    private Subscription textChangeSubscription;
    @Inject
    SplashActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        textChangeSubscription = RxTextView.textChangeEvents(etUsername).subscribe(new Action1<TextViewTextChangeEvent>() {
            @Override
            public void call(TextViewTextChangeEvent textViewTextChangeEvent) {
                presenter.username = textViewTextChangeEvent.text().toString();
                etUsername.setError(null);
            }
        });
    }

    @Override
    protected void setupActivityCompontent() {
        GithubClientApplication.get(this).getAppComponent().plus(new SplashActivityModule(this)).inject(this);
    }

    @OnClick(R.id.btnShowRepositories)
    public void onShowRepositoriesClick() {
        presenter.onShowRepositoriesClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textChangeSubscription.unsubscribe();
    }

    @Override
    public void showLoading(boolean loading) {
        btnShowRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showValidationError() {
        etUsername.setError("Validation Error");
    }

    @Override
    public void showRepositoriesListForUser(User user) {
        GithubClientApplication.get(this).createUserComponent(user);
        startActivity(new Intent(this, RepositoriesListActivity.class));
    }

    @Override
    public void toast(Throwable e) {
        Toast.makeText(this, "upload succeed", Toast.LENGTH_SHORT).show();
        if (e != null) {
            e.printStackTrace();
        }
    }

    /*@Override
    public void showToast(String username) {
        Toast.makeText(SplashActivity.this, username, Toast.LENGTH_SHORT).show();
    }*/
}
