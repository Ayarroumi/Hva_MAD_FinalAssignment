package com.example.anass.festivalapp.Retrofit;

import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Entities.Wallet;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WalletResponse {
    @SerializedName("wallets")
    @Expose
    ArrayList<Wallet> wallets;

    public ArrayList<Wallet> getWallets() {
        return wallets;
    }
}
