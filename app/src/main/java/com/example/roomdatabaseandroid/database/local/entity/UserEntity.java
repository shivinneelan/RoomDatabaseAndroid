package com.example.roomdatabaseandroid.database.local.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_user")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "column_id")
    public int id;

    @ColumnInfo(name = "column_user_name")
    public String user_name;

    @ColumnInfo(name = "column_password")
    public String password;

    @ColumnInfo(name = "column_name")
    public String name;

    @ColumnInfo(name = "column_address")
    public String address;


}
