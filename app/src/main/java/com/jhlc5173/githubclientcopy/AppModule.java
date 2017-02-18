package com.jhlc5173.githubclientcopy;

import android.app.Application;

import com.jhlc5173.githubclientcopy.utils.Validator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/6.
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Validator provideValidator() {
        return new Validator();
    }
}
