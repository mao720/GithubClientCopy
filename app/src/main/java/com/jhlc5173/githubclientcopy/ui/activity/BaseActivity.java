package com.jhlc5173.githubclientcopy.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/4.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityCompontent();
    }

    /**
     * 实现依赖注入的方法
     */
    protected abstract void setupActivityCompontent();
}
