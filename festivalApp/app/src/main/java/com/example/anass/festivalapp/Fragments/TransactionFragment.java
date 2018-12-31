package com.example.anass.festivalapp.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anass.festivalapp.Adapters.FestivalAdapter;
import com.example.anass.festivalapp.Adapters.TransactionAdapter;
import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewModel.FestivalViewModel;
import com.example.anass.festivalapp.ViewModel.TransactionViewModel;
import com.example.anass.festivalapp.ViewModel.UserViewModel;
import com.example.anass.festivalapp.ViewModel.WalletViewModel;

import java.util.List;


public class TransactionFragment extends Fragment{

    private TransactionViewModel transactionViewModel;
    private TransactionAdapter mAdapter;
    private RecyclerView mTransactionRecyclerView;

    public static TransactionFragment newInstance(){
        TransactionFragment fragment = new TransactionFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container,false);

        mTransactionRecyclerView = view.findViewById(R.id.transctionlList);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mTransactionRecyclerView.setLayoutManager(mLayoutManager);

        transactionViewModel = ViewModelProviders.of(this).get(TransactionViewModel.class);

        transactionViewModel.getAllTransactions(1).observe(this, new Observer<List<Transaction>>() {
            @Override
            public void onChanged(@Nullable List<Transaction> transactions) {
                mAdapter = new TransactionAdapter(getContext(), transactionViewModel.getAllTransactions(1).getValue());
                mTransactionRecyclerView.setAdapter(mAdapter);
            }
        });


        return view;
    }
}
