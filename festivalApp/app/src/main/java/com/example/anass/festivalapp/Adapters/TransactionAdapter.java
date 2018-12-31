package com.example.anass.festivalapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewHolders.FestivalViewHolder;
import com.example.anass.festivalapp.ViewHolders.TransactionViewHolder;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionViewHolder>{

    private Context context;
    public List<Transaction> listTransactions;


    public TransactionAdapter(Context context, List<Transaction> listTransactions) {
        this.context = context;
        this.listTransactions = listTransactions;
        this.context = context;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_grid_transaction, viewGroup, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder transactionViewHolder, int i) {
        final Transaction transaction = listTransactions.get(i);

        transactionViewHolder.transactionName.setText(transaction.getProduct());
        transactionViewHolder.transactionAmount.setText(Integer.toString(transaction.getAmount()));
        transactionViewHolder.transactionDate.setText(transaction.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return listTransactions.size();
    }
}
