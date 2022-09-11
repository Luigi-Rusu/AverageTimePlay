package com.playtika.user;

import java.time.LocalDate;

public class Day {
    private LocalDate localDate;
    private float time;
    private int numberPlayers;

    public Day(LocalDate localDate, float time) {
        this.localDate = localDate;
        this.time = time;
        numberPlayers = 1;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getNumberPlayers() {
        return numberPlayers;
    }

    public void setNumberPlayers(int numberPlayers) {
        this.numberPlayers = numberPlayers;
    }

    public void incrementCount() {
        this.numberPlayers++;
    }

    public void addTime(float time) {
        this.time += time;
    }

    public float getAverage() {
        return time / numberPlayers;
    }
}
