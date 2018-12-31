package com.example.anass.festivalapp.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anass.festivalapp.Activities.LoggedInActivity;
import com.example.anass.festivalapp.Activities.MainActivity;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewModel.UserViewModel;
import com.example.anass.festivalapp.ViewModel.WalletViewModel;

public class UpgradeFragment extends Fragment{

    private WalletViewModel walletViewModel;

    public static UpgradeFragment newInstance(){
        UpgradeFragment fragment = new UpgradeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wallet_upgrade, container,false);

        EditText upgradeAmount = view.findViewById(R.id.upgradeAmount);
        Button  upgradeButton = view.findViewById(R.id.upgradeButton);

        walletViewModel = ViewModelProviders.of(this).get(WalletViewModel.class);
        Wallet wallet  = walletViewModel.getWallet(1);

        upgradeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println("BEFORE!!! : " + wallet.getAmount());
                Double newAmount = Double.parseDouble(upgradeAmount.getText().toString()) + wallet.getAmount();
                wallet.setAmount(newAmount);
                walletViewModel.update(wallet);
            }
        });

        return view;
    }
}
