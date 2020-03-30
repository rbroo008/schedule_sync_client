package com.example.myapplication;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MoodleAssignment
{
    private String name;
    private LocalDateTime ldt;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public MoodleAssignment(String name, long epochTime)
    {
        this.name = name;
        // Convert epoch time, UTC, to LocalDateTime
        this.ldt = LocalDateTime.ofEpochSecond(epochTime, 0, ZoneOffset.of("-04:00"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDateString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getYear() {
        return ldt.getYear();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getMonth() {
        return ldt.getMonthValue();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getDay() {
        return ldt.getDayOfMonth();
    }
    public String getName()
    {
        return name;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getHour() {
        return ldt.getHour();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getMinute() {
        return ldt.getMinute();
    }
}
