package com.example.anass.festivalapp.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.anass.festivalapp.Dao.FestivalDao;
import com.example.anass.festivalapp.Dao.TicketDao;
import com.example.anass.festivalapp.Database.FestivalDatabase;
import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Ticket;
import com.example.anass.festivalapp.Retrofit.APIClient;
import com.example.anass.festivalapp.Retrofit.APIInterface;
import com.example.anass.festivalapp.Retrofit.FestivalsResponse;
import com.example.anass.festivalapp.Retrofit.TicketResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketRepository {

    private TicketDao ticketDao;
    private LiveData<List<Ticket>> allTickets;
    private APIInterface apiInterface;

    public TicketRepository(Application application) {
        FestivalDatabase festivalDatabase = FestivalDatabase.getInstance(application);
        ticketDao = festivalDatabase.ticketDao();
        allTickets = ticketDao.getAllTickets();
    }

    public void insert(Ticket ticket){
        new InsertTicketAsyncTask(ticketDao).execute(ticket);
    }

    public void update(Ticket ticket){
        new UpdateTicketAsyncTask(ticketDao).execute(ticket);
    }

    public void delete(Ticket ticket){
        new DeleteTicketAsyncTask(ticketDao).execute(ticket);
    }


    public LiveData<List<Ticket>> getAllTickets() {
            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<TicketResponse> call = apiInterface.getTickets();

            call.enqueue(new Callback<TicketResponse>() {
                @Override
                public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {
                    TicketResponse ticketsApi = response.body();

                    for(Ticket ticketApi: ticketsApi.getTickets()){
                        insert(ticketApi);

                    }
                }

                @Override
                public void onFailure(Call<TicketResponse> call, Throwable t) {
                    System.out.println("???????????????????" + t);

                    Log.d("error",t.toString());
                    call.cancel();
                }
            });




        return allTickets;
    }


    private static class InsertTicketAsyncTask extends AsyncTask<Ticket, Void, Void> {
        private TicketDao ticketDao;

        public InsertTicketAsyncTask(TicketDao ticketDao) {
            this.ticketDao = ticketDao;
        }

        @Override
        protected Void doInBackground(Ticket... tickets) {
            ticketDao.insert(tickets[0]);
            return null;
        }
    }

    private static class UpdateTicketAsyncTask extends AsyncTask<Ticket, Void, Void> {
        private TicketDao ticketDao;

        public UpdateTicketAsyncTask(TicketDao ticketDao) {
            this.ticketDao = ticketDao;
        }

        @Override
        protected Void doInBackground(Ticket... tickets) {
            ticketDao.update(tickets[0]);
            return null;
        }
    }

    private static class DeleteTicketAsyncTask extends AsyncTask<Ticket, Void, Void> {
        private TicketDao ticketDao;

        public DeleteTicketAsyncTask(TicketDao ticketDao) {
            this.ticketDao = ticketDao;
        }

        @Override
        protected Void doInBackground(Ticket... tickets) {
            ticketDao.delete(tickets[0]);
            return null;
        }
    }


}
