package com.ivan.mvvmdemo.ui.albums.view;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.ivan.mvvmdemo.R;
import com.ivan.mvvmdemo.base.BaseActivity;
import com.ivan.mvvmdemo.base.MyApplication;
import com.ivan.mvvmdemo.ui.albums.di.DaggerAlbumsComponent;
import com.ivan.mvvmdemo.ui.albums.model.Album;
import com.ivan.mvvmdemo.ui.albums.viewmodel.AlbumsViewModel;
import com.ivan.mvvmdemo.ui.albums.viewmodel.AlbumsViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements AlbumsView {

    @BindView(R.id.rv_albums)
    RecyclerView albums;

    @Inject
    AlbumsViewModelFactory mAlbumsViewModelFactory;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initializeDagger() {
        DaggerAlbumsComponent.builder()
                .applicationComponent(MyApplication.getApplicationComponent())
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlbumsViewModel albumsViewModel = new ViewModelProvider(this, mAlbumsViewModelFactory).get(AlbumsViewModel.class);
        albumsViewModel.getAlbums();
        albumsViewModel.populateAlbums().observe(this, albums -> {
            onSuccessAlbums(albums);
        });
    }

    @Override
    public void onSuccessAlbums(List<Album> albumsList) {
        albums.setAdapter(new AlbumAdapter(albumsList));
    }
}
