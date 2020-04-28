package com.ivan.mvvmdemo.dependencies.app;

import android.app.Application;
import com.ivan.mvvmdemo.dependencies.rest.endpoints.AlbumEndpoints;
import com.ivan.mvvmdemo.dependencies.rest.module.RestModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RestModule.class})
public interface ApplicationComponent {

    Application getApp();

    AlbumEndpoints albumEndpoints();
}
