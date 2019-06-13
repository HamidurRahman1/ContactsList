package com.hamidur.webCrawler.services;

public class TimeCalculator
{
    private long start;
    private long end;

    public TimeCalculator() {}

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public float getElapsedTime()
    {
        return (float)(end-start)/1000;
    }
}
