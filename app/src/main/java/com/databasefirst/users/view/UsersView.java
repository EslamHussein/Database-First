package com.databasefirst.users.view;

import com.databasefirst.base.view.MvpView;
import com.databasefirst.users.repo.dto.User;

import java.util.List;

/**
 * Created by Eslam Hussein on 3/3/18.
 */

public interface UsersView extends MvpView {

    void showUsers(List<User> users);
    void showLoading();
    void hideLoading();
    void showError(String error);
}
