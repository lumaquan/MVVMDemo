package com.ivan.mvvmdemo.ui.albums.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ivan.mvvmdemo.base.BaseViewModel;
import com.ivan.mvvmdemo.ui.albums.model.Album;
import com.ivan.mvvmdemo.ui.albums.repository.AlbumRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsViewModel extends BaseViewModel<AlbumRepository> {

    private MutableLiveData<List<Album>> albumsMutableLiveData;

    public AlbumsViewModel(AlbumRepository repository) {
        super(repository);
        albumsMutableLiveData = new MutableLiveData<>();
    }


    public void getAlbums() {

        mRepository.executeAlbums(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                albumsMutableLiveData.postValue(response.body());
                //mView.hideProgressDialog();

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                //mView.hideProgressDialog();
            }
        });
    }

    public LiveData<List<Album>> populateAlbums() {
        return albumsMutableLiveData;
    }
}
