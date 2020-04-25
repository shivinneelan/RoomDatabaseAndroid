package com.example.roomdatabaseandroid.database.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabaseandroid.database.local.entity.UserEntity;

import java.util.List;

@Dao
public interface AppDao {

    @Insert
    void insertBasic(UserEntity user);

    @Query("SELECT * FROM table_user")
    List<UserEntity> getUserlist();

    @Delete
    void delete(UserEntity user);
}
