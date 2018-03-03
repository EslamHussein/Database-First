package com.databasefirst.base.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.databasefirst.base.presenter.MvpPresenter;


public abstract class BaseActivity<T extends MvpPresenter> extends AppCompatActivity implements MvpView {

    private T presenter;

    protected
    @NonNull
    T getPresenter() {
        if (presenter == null)
            presenter = createPresenter();
        if (presenter == null)
            throw new IllegalStateException("createPresenter() implementation returns null!");
        return presenter;
    }

    protected abstract T createPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().onAttach(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().onDetach();
    }
}