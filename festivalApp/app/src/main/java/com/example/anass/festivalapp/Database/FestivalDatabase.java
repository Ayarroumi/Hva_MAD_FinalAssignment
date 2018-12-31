package com.example.anass.festivalapp.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.anass.festivalapp.Dao.FestivalDao;
import com.example.anass.festivalapp.Dao.TicketDao;
import com.example.anass.festivalapp.Dao.TransactionDao;
import com.example.anass.festivalapp.Dao.UserDao;
import com.example.anass.festivalapp.Dao.WalletDao;
import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Ticket;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;

@Database(entities = {Festival.class, Transaction.class, User.class, Wallet.class, Ticket.class}, version = 2)
public abstract class FestivalDatabase extends RoomDatabase {

    private static FestivalDatabase instance;
    public abstract FestivalDao festivalDao();
    public abstract TransactionDao transactionDao();
    public abstract UserDao userDao();
    public abstract WalletDao walletDao();
    public abstract TicketDao ticketDao();

    public static synchronized  FestivalDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FestivalDatabase.class, "wow")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private FestivalDao festivalDao;
        private TransactionDao transactionDao;
        private UserDao userDao;
        private WalletDao walletDao;
        private TicketDao ticketDao;

        private PopulateDbAsyncTask(FestivalDatabase db){
            festivalDao = db.festivalDao();
            transactionDao = db.transactionDao();
            userDao = db.userDao();
            walletDao = db.walletDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDao.insert(new User(1,"Anass","Yarroumi"));
            walletDao.insert(new Wallet(1,10.0, 1));
            return null;
        }
    }



}
