package com.example.anass.festivalapp.Fragments;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.anass.festivalapp.Activities.LoggedInActivity;
import com.example.anass.festivalapp.Activities.MainActivity;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewModel.UserViewModel;
import com.example.anass.festivalapp.ViewModel.WalletViewModel;

public class HomeFragment extends Fragment{


    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);

        Button walletButton = view.findViewById(R.id.walletButton);
        Button festivalButton = view.findViewById(R.id.festivalsButton);
        Button myTicketsButton = view.findViewById(R.id.myTicketsButton);

        walletButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((LoggedInActivity)getActivity()).setmViewPager("WalletFragment");
            }
        });

        festivalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoggedInActivity)getActivity()).setmViewPager("FestivalFragment");
            }
        });

        myTicketsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoggedInActivity)getActivity()).setmViewPager("MyTicketFragment");
            }
        });


        return view;
    }
}
