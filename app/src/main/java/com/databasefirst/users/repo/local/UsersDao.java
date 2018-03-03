package com.databasefirst.users.repo.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.databasefirst.users.repo.dto.User;

import java.util.List;

/**
 * Created by EslamHussein on 12/29/17.
 */
@Dao
public interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> items);

    @Query("SELECT * FROM " + DBConstant.USERS_TABLE_NAME)
    List<User> getAll();

}
