package com.ivan.mvvmdemo.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel<R extends BaseRepository> extends ViewModel implements BaseViewModelContract {

    protected R mRepository;

    private MutableLiveData<Boolean> loading;

    public BaseViewModel(R mRepository) {
        this.mRepository = mRepository;
        loading = new MutableLiveData<>();
    }

    @Override
    public LiveData<Boolean> getLoading() {
        return loading;
    }
}
