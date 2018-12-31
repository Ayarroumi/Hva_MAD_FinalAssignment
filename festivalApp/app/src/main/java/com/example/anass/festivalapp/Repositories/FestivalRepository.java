package com.example.anass.festivalapp.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.anass.festivalapp.Dao.FestivalDao;
import com.example.anass.festivalapp.Database.FestivalDatabase;
import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Retrofit.APIClient;
import com.example.anass.festivalapp.Retrofit.APIInterface;
import com.example.anass.festivalapp.Retrofit.FestivalsResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FestivalRepository {

    private FestivalDao festivalDao;
    private LiveData<List<Festival>> allFestivals;
    private APIInterface apiInterface;

    public FestivalRepository(Application application) {
        FestivalDatabase festivalDatabase = FestivalDatabase.getInstance(application);
        festivalDao = festivalDatabase.festivalDao();
        allFestivals = festivalDao.getAllFestivals();
    }

    public void insert(Festival festival){
        new InsertFestivalAsyncTask(festivalDao).execute(festival);
    }

    public void update(Festival festival){
        new UpdateFestivalAsyncTask(festivalDao).execute(festival);
    }

    public void delete(Festival festival){
        new DeleteFestivalAsyncTask(festivalDao).execute(festival);
    }


    public LiveData<List<Festival>> getAllFestivals() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<FestivalsResponse> call = apiInterface.getFestivals();

        call.enqueue(new Callback<FestivalsResponse>() {
            @Override
            public void onResponse(Call<FestivalsResponse> call, Response<FestivalsResponse> response) {
                FestivalsResponse festivalsApi = response.body();

                for(Festival festivalApi: festivalsApi.getFestivals()){
                    new festivalExistsAsyncTask(festivalDao, new OnResultCallback<Festival>() {
                        @Override
                        public void onSucces(Festival festival) {
                            if(festival == null){
                                insert(festivalApi);
                            }
                        }

                        @Override
                        public void onFailure(Exception e) {

                        }

                    }).execute(festivalApi);

                }
            }

            @Override
            public void onFailure(Call<FestivalsResponse> call, Throwable t) {
                System.out.println("???????????????????" + t);

                Log.d("error",t.toString());
                call.cancel();
            }
        });

        return allFestivals;
    }



    private static class festivalExistsAsyncTask extends AsyncTask<Festival, Void, Festival> {
        private FestivalDao festivalDao;
        private OnResultCallback<Festival> mCallback;

        public festivalExistsAsyncTask(FestivalDao festivalDao, OnResultCallback callback) {
            this.festivalDao = festivalDao;
            this.mCallback = callback;
        }

        @Override
        protected Festival doInBackground(Festival... festivals) {
            return festivalDao.getFestival(festivals[0].getId());
        }

        @Override
        protected void onPostExecute(Festival festival) {
            super.onPostExecute(festival);
            mCallback.onSucces(festival);
        }
    }


    private static class InsertFestivalAsyncTask extends AsyncTask<Festival, Void, Void> {
        private FestivalDao festivalDao;

        public InsertFestivalAsyncTask(FestivalDao festivalDao) {
            this.festivalDao = festivalDao;
        }

        @Override
        protected Void doInBackground(Festival... festivals) {
            festivalDao.insert(festivals[0]);
            return null;
        }
    }

    private static class UpdateFestivalAsyncTask extends AsyncTask<Festival, Void, Void> {
        private FestivalDao festivalDao;

        public UpdateFestivalAsyncTask(FestivalDao festivalDao) {
            this.festivalDao = festivalDao;
        }

        @Override
        protected Void doInBackground(Festival... festivals) {
            festivalDao.update(festivals[0]);
            return null;
        }
    }

    private static class DeleteFestivalAsyncTask extends AsyncTask<Festival, Void, Void> {
        private FestivalDao festivalDao;

        public DeleteFestivalAsyncTask(FestivalDao festivalDao) {
            this.festivalDao = festivalDao;
        }

        @Override
        protected Void doInBackground(Festival... festivals) {
            festivalDao.delete(festivals[0]);
            return null;
        }
    }


}
