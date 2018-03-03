package com.databasefirst.users.presenter;


import com.databasefirst.base.presenter.BasePresenter;
import com.databasefirst.users.view.UsersView;


public abstract class UsersPresenter extends BasePresenter<UsersView> {

    public abstract void getUsers();
}
