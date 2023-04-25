package ru.andrew116st.springcourse.util;

public class SensorNotRegisteredException extends RuntimeException {
    public SensorNotRegisteredException(String msg){
        super (msg);
    }

}
