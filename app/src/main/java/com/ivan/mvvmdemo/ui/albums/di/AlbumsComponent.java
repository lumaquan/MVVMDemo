package com.ivan.mvvmdemo.ui.albums.di;

import com.ivan.mvvmdemo.base.CustomScope;
import com.ivan.mvvmdemo.dependencies.app.ApplicationComponent;
import com.ivan.mvvmdemo.ui.albums.view.MainActivity;

import dagger.Component;

@CustomScope
@Component(dependencies = ApplicationComponent.class, modules = AlbumsModule.class)
public interface AlbumsComponent {
    void inject(MainActivity mainActivity);
}
