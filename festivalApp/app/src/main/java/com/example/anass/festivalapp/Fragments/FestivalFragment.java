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
import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewModel.FestivalViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FestivalFragment extends Fragment{
    private FestivalViewModel festivalViewModel;
    private FestivalAdapter mAdapter;
    private RecyclerView mFestivalRecyclerView;


    public static FestivalFragment newInstance(){
        FestivalFragment fragment = new FestivalFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_festival, container,false);

        mFestivalRecyclerView = view.findViewById(R.id.festivalList);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mFestivalRecyclerView.setLayoutManager(mLayoutManager);

        festivalViewModel = ViewModelProviders.of(this).get(FestivalViewModel.class);
        System.out.println();
        festivalViewModel.getAllFestivals().observe(this, new Observer<List<Festival>>() {
            @Override
            public void onChanged(@Nullable List<Festival> festivals) {
                mAdapter = new FestivalAdapter(getContext(), festivalViewModel.getAllFestivals().getValue());
                mFestivalRecyclerView.setAdapter(mAdapter);
            }
        });

        return view;
    }
}
