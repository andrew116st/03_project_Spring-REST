package ru.andrew116st.springcourse.util;

public class SensorErrorResponse {
    private String name;
    private long timestamp;

    public SensorErrorResponse(String s, long currentTimeMillis) {
        this.name=s;
        this.timestamp=currentTimeMillis;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
