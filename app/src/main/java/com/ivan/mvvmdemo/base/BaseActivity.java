package com.ivan.mvvmdemo.base;

import android.app.Dialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.ivan.mvvmdemo.R;
import butterknife.ButterKnife;

public abstract class BaseActivity
        extends AppCompatActivity
        implements BaseViewContract {

    protected Dialog mProgressDialog;
    protected boolean mIsDialogShowing;

    protected abstract @LayoutRes
    int getLayout();

    protected void initializeDagger() {
        //Empty method goes here
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initializeDagger();
        setProgressDialog();
    }

    private void setProgressDialog() {
        mProgressDialog = new Dialog(this);
        mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mProgressDialog.setCancelable(false);
        View view = LayoutInflater.from(this).inflate(R.layout.custom_progress_dialog, null);
        ProgressBar progressBar = view.findViewById(R.id.cargando_progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this, R.color.regresar_passwordActivity), PorterDuff.Mode.SRC_IN);
        mProgressDialog.setContentView(view);
    }

    @Override
    public void showProgressDialog() {
        if (!mIsDialogShowing && mProgressDialog != null) {
            mProgressDialog.show();
            mIsDialogShowing = true;
        }
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null && (mIsDialogShowing || mProgressDialog.isShowing())) {
            mProgressDialog.dismiss();
            mIsDialogShowing = false;
        }
    }
}
