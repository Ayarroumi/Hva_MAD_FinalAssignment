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
import com.example.anass.festivalapp.Adapters.TicketAdapter;
import com.example.anass.festivalapp.Entities.Ticket;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewModel.FestivalViewModel;
import com.example.anass.festivalapp.ViewModel.TicketViewModel;
import com.example.anass.festivalapp.ViewModel.UserViewModel;
import com.example.anass.festivalapp.ViewModel.WalletViewModel;

import java.util.List;


public class MyTicketFragment extends Fragment{

    private TicketViewModel ticketViewModel;
    private TicketAdapter mAdapter;
    private RecyclerView mTicketRecyclerView;

    public static MyTicketFragment newInstance(){
        MyTicketFragment fragment = new MyTicketFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket, container,false);

        mTicketRecyclerView = view.findViewById(R.id.ticketlList);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mTicketRecyclerView.setLayoutManager(mLayoutManager);


        ticketViewModel = ViewModelProviders.of(this).get(TicketViewModel.class);
        System.out.println();
        ticketViewModel.getAllTickets().observe(this, new Observer<List<Ticket>>() {
            @Override
            public void onChanged(@Nullable List<Ticket> tickets) {
                mAdapter = new TicketAdapter(getContext(), ticketViewModel.getAllTickets().getValue());
                mTicketRecyclerView.setAdapter(mAdapter);
            }
        });

        return view;
    }
}
