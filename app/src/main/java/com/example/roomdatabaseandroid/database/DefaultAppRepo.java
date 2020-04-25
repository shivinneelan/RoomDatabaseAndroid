package com.example.roomdatabaseandroid.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.roomdatabaseandroid.database.AppRepository;
import com.example.roomdatabaseandroid.database.local.AppDao;
import com.example.roomdatabaseandroid.database.local.AppRoomDatabse;
import com.example.roomdatabaseandroid.database.local.entity.UserEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DefaultAppRepo implements AppRepository {
    private AppDao appDao;

    /**
     * Repository class to access database
     * @param application provide with getApplicationContext()
     */
    public DefaultAppRepo(Application application) {
        AppRoomDatabse appDatabase = AppRoomDatabse.getInstance(application);
        appDao = appDatabase.appDao();
    }


    /**
     *  add User data to User table Async Task method
     * @param user
     */
    @Override
    public void insertUser(UserEntity user) {
        new InsertUserAsyncTask(appDao).execute(user);
    }

    /**
     *
     * @return  List of user details
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    public List<UserEntity> getAllUsers() throws ExecutionException, InterruptedException {
        return new GetAllUsers(appDao).execute().get();
    }

    /**
     * delet corresponding user
     * @param user
     */
    @Override
    public void deleteUser(UserEntity user) {
        new DeletetUserAsyncTask(appDao).execute(user);

    }


    private class InsertUserAsyncTask extends AsyncTask<UserEntity, Void, Void> {

        private AppDao appDao;

        public InsertUserAsyncTask(AppDao appDao) {
            this.appDao = appDao;
        }

        @Override
        protected Void doInBackground(UserEntity... user) {
            appDao.insertBasic(user[0]);
            return null;
        }

    }

    private class GetAllUsers extends AsyncTask<Void, Void, List<UserEntity>> {

        private AppDao appDao;

        public GetAllUsers(AppDao appDao) {
            this.appDao = appDao;
        }

        @Override
        protected List<UserEntity> doInBackground(Void... voids) {
            return appDao.getUserlist();
        }
    }


    private class DeletetUserAsyncTask extends AsyncTask<UserEntity, Void, Void> {

        private AppDao appDao;

        public DeletetUserAsyncTask(AppDao appDao) {
            this.appDao = appDao;
        }

        @Override
        protected Void doInBackground(UserEntity... user) {
            appDao.delete(user[0]);
            return null;
        }

    }
}



