package com.ivan.mvvmdemo.ui.albums.repository;

import com.ivan.mvvmdemo.base.BaseRepository;
import com.ivan.mvvmdemo.dependencies.rest.endpoints.AlbumEndpoints;
import com.ivan.mvvmdemo.ui.albums.model.Album;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Callback;

public class AlbumRepositoryImpl implements AlbumRepository {

    private AlbumEndpoints mAlbumEndpoints;

    @Inject
    AlbumRepositoryImpl(AlbumEndpoints albumEndpoints) {
        mAlbumEndpoints = albumEndpoints;
    }

    @Override
    public void executeAlbums(Callback<List<Album>> responseCallback) {
        mAlbumEndpoints.getAlbums().enqueue(responseCallback);
    }
}
