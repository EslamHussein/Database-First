package com.databasefirst.users.repo;

import com.databasefirst.users.repo.dto.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by EslamHussein on 3/3/18.
 */

public interface UsersRepo {
    Observable<List<User>> getAllUsers();
}
