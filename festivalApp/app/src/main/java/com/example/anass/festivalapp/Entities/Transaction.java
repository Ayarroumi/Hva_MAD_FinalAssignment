package com.example.anass.festivalapp.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "userId",
                onDelete = CASCADE
        ),
        @ForeignKey(
                entity = Festival.class,
                parentColumns = "id",
                childColumns = "festivalId",
                onDelete = CASCADE
        )
    },tableName = "transactions")

public class Transaction{

    @PrimaryKey
    private int id;

    private String date;
    private String product;
    private int amount;
    private double price;
    private final int userId;
    private final int festivalId;

    public Transaction(int id, String date, String product, int amount, double price, int userId, int festivalId) {
        this.id = id;
        this.date = date;
        this.product = product;
        this.amount = amount;
        this.price = price;
        this.userId = userId;
        this.festivalId = festivalId;
    }

    public int getUserId() {
        return userId;
    }

    public int getFestivalId() {
        return festivalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
