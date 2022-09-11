package com.playtika.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private LocalDate dateTime;
    private String username;
    private float time;

    private boolean isCalculated;

    public User(LocalDate dateTime, String username, float time) {
        this.dateTime = dateTime;
        this.username = username;
        this.time = time;
        this.isCalculated = false;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public boolean isCalculated() {
        return isCalculated;
    }

    public void setCalculated(boolean calculated) {
        isCalculated = calculated;
    }
}
