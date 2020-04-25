package com.example.roomdatabaseandroid.database.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabaseandroid.database.local.entity.UserEntity;

@Database(
        entities =
                {UserEntity.class},
        version = 1
                )
public abstract class AppRoomDatabse extends RoomDatabase {
    public abstract AppDao appDao();
    private static volatile AppRoomDatabse INSTANCE;

    public static AppRoomDatabse getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppRoomDatabse.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context,
                            AppRoomDatabse.class,
                            "app_database"
                    ).build();
                }
            }
        }

        return INSTANCE;
    }


}
