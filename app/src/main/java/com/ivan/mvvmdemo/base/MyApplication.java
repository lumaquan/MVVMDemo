package com.ivan.mvvmdemo.base;

import android.app.Application;
import com.ivan.mvvmdemo.dependencies.app.ApplicationComponent;
import com.ivan.mvvmdemo.dependencies.app.ApplicationModule;
import com.ivan.mvvmdemo.dependencies.app.DaggerApplicationComponent;
import com.ivan.mvvmdemo.dependencies.rest.module.RestModule;
import com.ivan.mvvmdemo.utils.Constants;

public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentDagger();
    }

    private void buildComponentDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .restModule(new RestModule(Constants.Endpoints.BASE_URL))
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
