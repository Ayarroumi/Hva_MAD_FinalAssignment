package com.example.anass.festivalapp.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.anass.festivalapp.Dao.FestivalDao;
import com.example.anass.festivalapp.Dao.TransactionDao;
import com.example.anass.festivalapp.Dao.WalletDao;
import com.example.anass.festivalapp.Database.FestivalDatabase;
import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.Retrofit.APIClient;
import com.example.anass.festivalapp.Retrofit.APIInterface;
import com.example.anass.festivalapp.Retrofit.FestivalsResponse;
import com.example.anass.festivalapp.Retrofit.TransactionsResponse;
import com.example.anass.festivalapp.Retrofit.WalletResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WalletRepository {

    private WalletDao walletDao;
    private APIInterface apiInterface;


    public WalletRepository(Application application) {
        FestivalDatabase festivalDatabase = FestivalDatabase.getInstance(application);
        walletDao = festivalDatabase.walletDao();
    }

    public void insert(Wallet wallet){
        new InsertWalletAsyncTask(walletDao).execute(wallet);
    }

    public void update(Wallet wallet){
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Wallet> call = apiInterface.patchWallet(wallet);
        System.out.println(call.request());
        call.enqueue(new Callback<Wallet>() {
            @Override
            public void onResponse(Call<Wallet> call, Response<Wallet> response) {
                new UpdateWalletAsyncTask(walletDao).execute(wallet);
            }

            @Override
            public void onFailure(Call<Wallet> call, Throwable t) {

            }
        });
    }

    public void delete(Wallet wallet){
        new DeleteWalletAsyncTask(walletDao).execute(wallet);
    }

    public Wallet getWallet(int id ){
        final Wallet wallet = new Wallet();

        new getWalletAsyncTask(walletDao, new OnResultCallback<Wallet>() {
            @Override
            public void onSucces(Wallet object) {
                wallet.setAmount(object.getAmount());
                wallet.setId(object.getId());
                wallet.setUserId(object.getUserId());
            }

            @Override
            public void onFailure(Exception e) {

            }

        }).execute(id);


        return wallet;
    }



    private static class InsertWalletAsyncTask extends AsyncTask<Wallet, Void, Void> {
        private WalletDao walletDao;

        public InsertWalletAsyncTask(WalletDao walletDao) {
            this.walletDao = walletDao;
        }

        @Override
        protected Void doInBackground(Wallet... wallets) {
            walletDao.insert(wallets[0]);
            return null;
        }
    }

    private static class UpdateWalletAsyncTask extends AsyncTask<Wallet, Void, Void> {
        private WalletDao walletDao;

        public UpdateWalletAsyncTask(WalletDao walletDao) {
            this.walletDao = walletDao;
        }

        @Override
        protected Void doInBackground(Wallet... wallets) {
            walletDao.update(wallets[0]);
            return null;
        }
    }

    private static class DeleteWalletAsyncTask extends AsyncTask<Wallet, Void, Void> {
        private WalletDao walletDao;

        public DeleteWalletAsyncTask(WalletDao walletDao) {
            this.walletDao = walletDao;
        }

        @Override
        protected Void doInBackground(Wallet... wallets) {
            walletDao.delete(wallets[0]);
            return null;
        }
    }


    private static class getWalletAsyncTask extends AsyncTask<Integer, Wallet, Wallet> {
        private WalletDao walletDao;
        private OnResultCallback<Wallet> mCallback;

        public getWalletAsyncTask(WalletDao walletDao, OnResultCallback callback) {
            this.walletDao = walletDao;
            this.mCallback = callback;
        }

        @Override
        protected Wallet doInBackground(Integer... integers) {
            return walletDao.getWallet(integers[0]);
        }

        @Override
        protected void onPostExecute(Wallet wallet) {
            super.onPostExecute(wallet);
            mCallback.onSucces(wallet);
        }
    }


}
