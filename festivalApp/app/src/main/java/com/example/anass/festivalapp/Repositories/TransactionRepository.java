package com.example.anass.festivalapp.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.anass.festivalapp.Dao.FestivalDao;
import com.example.anass.festivalapp.Dao.TransactionDao;
import com.example.anass.festivalapp.Database.FestivalDatabase;
import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Retrofit.APIClient;
import com.example.anass.festivalapp.Retrofit.APIInterface;
import com.example.anass.festivalapp.Retrofit.FestivalsResponse;
import com.example.anass.festivalapp.Retrofit.TransactionsResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionRepository {

    private TransactionDao transactionDao;
    private APIInterface apiInterface;
    private LiveData<List<Transaction>> allTransactions;

    public TransactionRepository(Application application) {
        FestivalDatabase festivalDatabase = FestivalDatabase.getInstance(application);
        transactionDao = festivalDatabase.transactionDao();
        allTransactions = transactionDao.getAllTransactions();
    }


    public void insert(Transaction transaction){
        new TransactionRepository.InsertTransactionAsyncTask(transactionDao).execute(transaction);
    }

    public void update(Transaction transaction){
        new TransactionRepository.UpdateTransactionAsyncTask(transactionDao).execute(transaction);
    }

    public void delete(Transaction transaction){
        new TransactionRepository.DeleteTransactionAsyncTask(transactionDao).execute(transaction);
    }

    public LiveData<List<Transaction>> getAllTransactions(int id) {
        if(id != -1) {
            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<TransactionsResponse> call = apiInterface.getTransactions(id);
            call.enqueue(new Callback<TransactionsResponse>() {
                @Override
                public void onResponse(Call<TransactionsResponse> call, Response<TransactionsResponse> response) {
                    TransactionsResponse transactionsApi = response.body();
                    for (Transaction transactionApi : transactionsApi.getTransactions()){
                        new transactionExistsAsyncTask(transactionDao, new OnResultCallback<Transaction>() {

                            @Override
                            public void onSucces(Transaction transaction) {
                                if(transaction == null){
                                    insert(transactionApi);
                                }else{ }
                            }

                            @Override
                            public void onFailure(Exception e) {

                            }

                        }).execute(transactionApi);
                    }

                }

                @Override
                public void onFailure(Call<TransactionsResponse> call, Throwable t) {
                    System.out.println("!!!!!!!!!!!!!!! FOUT" + t.toString());
                }
            });

        }

        return allTransactions;
    }

    private static class transactionExistsAsyncTask extends AsyncTask<Transaction, Void, Transaction> {
        private TransactionDao transactionDao;
        private OnResultCallback<Transaction> mCallback;

        public transactionExistsAsyncTask(TransactionDao transactionDao, OnResultCallback callback) {
            this.transactionDao = transactionDao;
            this.mCallback = callback;
        }

        @Override
        protected Transaction doInBackground(Transaction... transactions) {
            return transactionDao.getTransaction(transactions[0].getId());
        }

        @Override
        protected void onPostExecute(Transaction transaction) {
            super.onPostExecute(transaction);
            mCallback.onSucces(transaction);
        }
    }


    private static class InsertTransactionAsyncTask extends AsyncTask<Transaction, Void, Void> {
        private TransactionDao transactionDao;

        public InsertTransactionAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.insert(transactions[0]);
            return null;
        }
    }

    private static class UpdateTransactionAsyncTask extends AsyncTask<Transaction, Void, Void> {
        private TransactionDao transactionDao;

        public UpdateTransactionAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.update(transactions[0]);
            return null;
        }
    }

    private static class DeleteTransactionAsyncTask extends AsyncTask<Transaction, Void, Void> {
        private TransactionDao transactionDao;

        public DeleteTransactionAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.delete(transactions[0]);
            return null;
        }
    }





}
