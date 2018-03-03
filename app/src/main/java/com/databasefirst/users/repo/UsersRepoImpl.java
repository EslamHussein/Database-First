package com.databasefirst.users.repo;

import com.databasefirst.users.repo.dto.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Eslam Hussein on 3/3/18.
 */

public class UsersRepoImpl implements UsersRepo{

    UsersRepo remoteUsersRepo;

    public UsersRepoImpl(UsersRepo remoteUsersRepo) {
        this.remoteUsersRepo = remoteUsersRepo;
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return remoteUsersRepo.getAllUsers();
    }
}
