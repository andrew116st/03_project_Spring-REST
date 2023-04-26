package ru.andrew116st.springcourse.util;

public class MeasurementNotRegisteredException extends RuntimeException {

    public MeasurementNotRegisteredException(String msg){

        super (msg);
    }

}