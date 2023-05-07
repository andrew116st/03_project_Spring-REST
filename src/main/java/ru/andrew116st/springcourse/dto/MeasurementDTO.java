package ru.andrew116st.springcourse.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementDTO {

    @NotNull(message = "Sensor not identified")
    private SensorDTO sensor;

    @NotNull(message = "Parameter value is incorrect")
    private Boolean raining;

    @NotNull(message = "The temperature value must not be empty")
    @Min(value = -100, message = "Please enter a value greater than -100 ")
    @Max(value = 100, message = "Please enter a value less than - 100 ")
    private Double value;

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
