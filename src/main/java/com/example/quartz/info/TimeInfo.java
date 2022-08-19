package com.example.quartz.info;

public class TimeInfo {
    private int totalFirecount;
    private boolean runforever;
    private long repeatIntervalMs;
    private long InitialOffsetMs;
    private String callbackData;


    public int getTotalFirecount() {
        return totalFirecount;
    }

    public void setTotalFirecount(int totalFirecount) {
        this.totalFirecount = totalFirecount;
    }

    public boolean isRunforever() {
        return runforever;
    }

    public void setRunforever(boolean runforever) {
        this.runforever = runforever;
    }

    public long getRepeatIntervalMs() {
        return repeatIntervalMs;
    }

    public void setRepeatIntervalMs(long repeatIntervalMs) {
        this.repeatIntervalMs = repeatIntervalMs;
    }

    public long getInitialOffsetMs() {
        return InitialOffsetMs;
    }

    public void setInitialOffsetMs(long initialOffsetMs) {
        InitialOffsetMs = initialOffsetMs;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }
}
