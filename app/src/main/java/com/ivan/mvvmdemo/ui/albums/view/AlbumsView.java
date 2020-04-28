package com.ivan.mvvmdemo.ui.albums.view;

import com.ivan.mvvmdemo.base.BaseViewContract;
import com.ivan.mvvmdemo.ui.albums.model.Album;
import java.util.List;

public interface AlbumsView extends BaseViewContract {
    void onSuccessAlbums(List<Album> albums);
}
