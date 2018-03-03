package com.databasefirst.users.repo.remote;

import com.databasefirst.users.repo.dto.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by EslamHussein on 3/3/18.
 */

public interface UsersServices {

    @GET("users")
    Observable<List<User>> getUsers();

}
