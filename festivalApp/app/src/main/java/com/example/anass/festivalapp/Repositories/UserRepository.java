package com.example.anass.festivalapp.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.anass.festivalapp.Dao.FestivalDao;
import com.example.anass.festivalapp.Dao.UserDao;
import com.example.anass.festivalapp.Dao.WalletDao;
import com.example.anass.festivalapp.Database.FestivalDatabase;
import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.Retrofit.APIClient;
import com.example.anass.festivalapp.Retrofit.APIInterface;
import com.example.anass.festivalapp.Retrofit.FestivalsResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Application application) {
        FestivalDatabase festivalDatabase = FestivalDatabase.getInstance(application);
        userDao = festivalDatabase.userDao();
    }

    public void insert(User user){
        new InsertUserAsyncTask(userDao).execute(user);
    }

    public void update(User user){
        new UpdateUserAsyncTask(userDao).execute(user);
    }

    public void delete(User user){
        new DeleteUserAsyncTask(userDao).execute(user);
    }

    public User getUser(int id ){
        final User user = new User();

        new UserRepository.getUserAsyncTask(userDao, new OnResultCallback<User>() {
            @Override
            public void onSucces(User object) {
                user.setId(object.getId());
                user.setName(object.getName());
                user.setLastName(object.getLastName());
            }

            @Override
            public void onFailure(Exception e) {

            }

        }).execute(id);


        return user;
    }



    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        public InsertUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        public UpdateUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        public DeleteUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users[0]);
            return null;
        }
    }


    private static class getUserAsyncTask extends AsyncTask<Integer, User, User> {
        private UserDao userDao;
        private OnResultCallback<User> mCallback;

        public getUserAsyncTask(UserDao userDao, OnResultCallback callback) {
            this.userDao = userDao;
            this.mCallback = callback;
        }

        @Override
        protected User doInBackground(Integer... integers) {
            return userDao.getUser(integers[0]);
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            mCallback.onSucces(user);
        }
    }
}
