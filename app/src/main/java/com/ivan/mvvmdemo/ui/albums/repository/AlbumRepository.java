package com.ivan.mvvmdemo.ui.albums.repository;

import com.ivan.mvvmdemo.base.BaseRepository;
import com.ivan.mvvmdemo.ui.albums.model.Album;
import java.util.List;
import retrofit2.Callback;

public interface AlbumRepository extends BaseRepository {

    void executeAlbums(Callback<List<Album>> responseCallback);
}
