package com.example.anass.festivalapp.Retrofit;

import com.example.anass.festivalapp.Entities.Transaction;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TransactionsResponse {
    @SerializedName("transactions")
    @Expose
    ArrayList<Transaction> transactions;

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
