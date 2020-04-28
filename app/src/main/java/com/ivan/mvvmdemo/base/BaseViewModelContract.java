package com.ivan.mvvmdemo.base;

import androidx.lifecycle.LiveData;

public interface BaseViewModelContract {

    LiveData<Boolean> getLoading();
}