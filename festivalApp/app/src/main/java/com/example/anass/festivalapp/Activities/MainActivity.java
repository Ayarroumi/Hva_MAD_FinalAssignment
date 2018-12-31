package com.example.anass.festivalapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewModel.UserViewModel;
import com.example.anass.festivalapp.ViewModel.WalletViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        Intent intent = new Intent(this, LoggedInActivity.class);
        startActivity(intent);
    }
}
