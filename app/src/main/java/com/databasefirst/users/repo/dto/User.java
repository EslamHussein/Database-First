package com.databasefirst.users.repo.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.databasefirst.users.repo.local.DBConstant;
import com.google.gson.annotations.SerializedName;

/**
 * Created by EslamHussein on 3/3/18.
 */

@Entity(tableName = DBConstant.USERS_TABLE_NAME)
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConstant.USER_ID)
    private int id;


    @SerializedName("first_name")
    @ColumnInfo(name = DBConstant.USER_FIRST_NAME)
    private String firstName;


    @SerializedName("last_name")
    @ColumnInfo(name = DBConstant.USER_LAST_NAME)
    private String lastName;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
