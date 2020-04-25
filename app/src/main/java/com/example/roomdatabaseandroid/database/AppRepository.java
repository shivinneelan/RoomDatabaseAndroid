package com.example.roomdatabaseandroid.database;

import com.example.roomdatabaseandroid.database.local.entity.UserEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AppRepository {


    // user CRUD
    void insertUser(UserEntity user);

    List<UserEntity> getAllUsers() throws ExecutionException, InterruptedException;

    void deleteUser(UserEntity user);

}
