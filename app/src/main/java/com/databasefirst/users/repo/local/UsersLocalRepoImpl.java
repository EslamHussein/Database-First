package com.databasefirst.users.repo.local;

import com.databasefirst.base.remote.BaseRemote;
import com.databasefirst.base.remote.RemoteConfiguration;
import com.databasefirst.users.repo.UsersRepo;
import com.databasefirst.users.repo.dto.User;
import com.databasefirst.users.repo.remote.UsersRemoteRepo;
import com.databasefirst.users.repo.remote.UsersServices;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

/**
 * Created by Eslam Hussein on 3/3/18.
 */

public class UsersLocalRepoImpl implements UsersLocalRepo {
    private UsersDao usersDao;


    public UsersLocalRepoImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return usersDao.getAll();
            }
        });
    }

    @Override
    public void addUsers(List<User> users) {
        usersDao.insertAll(users);
    }


}
