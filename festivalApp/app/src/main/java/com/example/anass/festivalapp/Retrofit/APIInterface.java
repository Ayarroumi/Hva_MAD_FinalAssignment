package com.example.anass.festivalapp.Retrofit;

import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Ticket;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @POST("/login")
    Call<User> login(@Body LoginRequest body);

    @GET("/festivals")
    Call<FestivalsResponse> getFestivals();

    @GET("/tickets")
    Call<TicketResponse> getTickets();

    @GET("/transactions")
    Call<TransactionsResponse> getTransactions(@Query("userId") int userId);


    @GET("/tickets")
    Call<Ticket> getTickets(@Query("userId") int userId);


    @GET("/wallet")
    Call<Wallet> getWallet(@Query("userId") int userId);

    @PATCH("/wallet")
    Call<Wallet> patchWallet(@Body Wallet body);

    @GET("/wallets")
    Call<WalletResponse> getWallets(@Query("userId") int userId);
}
