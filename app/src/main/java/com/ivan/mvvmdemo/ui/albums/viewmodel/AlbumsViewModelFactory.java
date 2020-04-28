package com.ivan.mvvmdemo.ui.albums.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ivan.mvvmdemo.ui.albums.repository.AlbumRepository;

import javax.inject.Inject;

public class AlbumsViewModelFactory implements ViewModelProvider.Factory {

    private final AlbumRepository mAlbumRepository;

    @Inject
    public AlbumsViewModelFactory(AlbumRepository mAlbumRepository) {
        this.mAlbumRepository = mAlbumRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AlbumsViewModel(mAlbumRepository);
    }
}
