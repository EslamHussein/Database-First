package com.databasefirst.users.repo.remote;

import com.databasefirst.base.BaseRemote;
import com.databasefirst.base.RemoteConfiguration;
import com.databasefirst.users.repo.dto.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Eslam Hussein on 3/3/18.
 */

public class UsersRemoteRepoImpl extends BaseRemote implements UsersRemoteRepo {
    @Override
    public Observable<List<User>> getAllUsers() {
        return create(UsersServices.class, RemoteConfiguration.BASE_URL).getUsers();
    }
}
