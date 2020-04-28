package com.ivan.mvvmdemo.ui.albums.di;

import com.ivan.mvvmdemo.base.CustomScope;
import com.ivan.mvvmdemo.ui.albums.repository.AlbumRepository;
import com.ivan.mvvmdemo.ui.albums.repository.AlbumRepositoryImpl;
import com.ivan.mvvmdemo.ui.albums.viewmodel.AlbumsViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
abstract class AlbumsModule {

    @CustomScope
    @Provides
    static AlbumsViewModelFactory providesAlbumViewModelFactory(AlbumRepository albumRepository) {
        return new AlbumsViewModelFactory(albumRepository);
    }

    @CustomScope
    @Binds
    abstract AlbumRepository providesAlbumRepository(AlbumRepositoryImpl albumRepository);
}
