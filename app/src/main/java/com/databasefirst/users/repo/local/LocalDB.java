package com.databasefirst.users.repo.local;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.databasefirst.users.repo.dto.User;

/**
 * Created by Eslam Hussein on 3/3/18.
 */

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class LocalDB extends RoomDatabase {

    public abstract UsersDao usersDao();



}
