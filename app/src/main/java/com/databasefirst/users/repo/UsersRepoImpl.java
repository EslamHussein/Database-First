package com.databasefirst.users.repo;

import com.databasefirst.users.repo.dto.User;
import com.databasefirst.users.repo.local.UsersLocalRepo;
import com.databasefirst.users.repo.remote.UsersRemoteRepo;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Eslam Hussein on 3/3/18.
 */

public class UsersRepoImpl implements UsersRepo {

    UsersRemoteRepo remoteUsersRepo;
    UsersLocalRepo localUsersRepo;


    public UsersRepoImpl(UsersRemoteRepo remoteUsersRepo, UsersLocalRepo localUsersRepo) {
        this.remoteUsersRepo = remoteUsersRepo;
        this.localUsersRepo = localUsersRepo;
    }

    @Override
    public Observable<List<User>> getAllUsers() {

        return Observable.mergeDelayError(remoteUsersRepo.getAllUsers().doOnNext(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        localUsersRepo.addUsers(users);
                    }
                }).subscribeOn(Schedulers.io()), localUsersRepo.getAllUsers().subscribeOn(Schedulers.io())
        );

    }

}
