package com.example.anass.festivalapp.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

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
}, tableName = "tickets")
public class Ticket {

    @PrimaryKey
    private int id;

    private String name;
    private String ticketUrl;
    private final int userId;
    private final int festivalId;

    public Ticket(String name, String ticketUrl, int userId, int festivalId) {
        this.name = name;
        this.ticketUrl = ticketUrl;
        this.userId = userId;
        this.festivalId = festivalId;
    }

    public int getUserId() {
        return userId;
    }

    public int getFestivalId() {
        return festivalId;
    }

    public String getTicketUrl() {
        return ticketUrl;
    }

    public void setTicketUrl(String ticketUrl) {
        this.ticketUrl = ticketUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
