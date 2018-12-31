package com.example.anass.festivalapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.anass.festivalapp.Activities.LoggedInActivity;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewModel.UserViewModel;
import com.example.anass.festivalapp.ViewModel.WalletViewModel;

public class WalletFragment extends Fragment{


    public static WalletFragment newInstance(){
        WalletFragment fragment = new WalletFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);

        Button transactionButton = view.findViewById(R.id.transactionsButton);
        Button upgradeButton = view.findViewById(R.id.upgradeButtonFragment);

        transactionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((LoggedInActivity)getActivity()).setmViewPager("TransactionFragment");
            }
        });

        upgradeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((LoggedInActivity)getActivity()).setmViewPager("UpgradeFragment");
            }
        });

        return view;
    }
}
