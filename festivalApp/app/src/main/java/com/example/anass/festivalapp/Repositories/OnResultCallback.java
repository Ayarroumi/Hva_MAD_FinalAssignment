package com.example.anass.festivalapp.Repositories;

public interface OnResultCallback<T> {
    public void onSucces(T object);
    public void onFailure(Exception e);
}
