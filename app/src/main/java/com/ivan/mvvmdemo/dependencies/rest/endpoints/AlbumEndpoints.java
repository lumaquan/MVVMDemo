package com.ivan.mvvmdemo.dependencies.rest.endpoints;

import com.ivan.mvvmdemo.ui.albums.model.Album;
import com.ivan.mvvmdemo.utils.Constants;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumEndpoints {

    @GET(Constants.Endpoints.ALBUMS)
    Call<List<Album>> getAlbums();
}
