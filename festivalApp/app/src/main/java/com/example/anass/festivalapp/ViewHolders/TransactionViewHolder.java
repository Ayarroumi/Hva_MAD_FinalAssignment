package com.example.anass.festivalapp.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anass.festivalapp.R;


public class TransactionViewHolder extends RecyclerView.ViewHolder {

    public TextView transactionName;
    public TextView transactionAmount;
    public TextView transactionDate;

    public TransactionViewHolder(View itemView) {
        super(itemView);
        transactionName = itemView.findViewById(R.id.transaction_name);
        transactionAmount = itemView.findViewById(R.id.transaction_amount);
        transactionDate = itemView.findViewById(R.id.transaction_date);
    }


}