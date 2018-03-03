package com.databasefirst.users.repo.local;

import com.databasefirst.users.repo.dto.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Eslam Hussein on 3/3/18.
 */

public interface UsersLocalRepo {
    Observable<List<User>> getAllUsers();
    void addUsers(List<User> users);

}
