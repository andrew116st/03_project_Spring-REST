package ru.andrew116st.springcourse.FirstRestApp.dto;

import ru.andrew116st.springcourse.FirstRestApp.models.Sensor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementDTO {

    @NotNull(message = "Сенсор не идентифицирован")
    private SensorDTO sensor;

    @NotNull(message = "Значение параметра некорректно")
    private Boolean raining;

    @NotNull(message = "Значение температуры не должно быть пустым")
    @Min(value = -100, message = "Введите значение больше -100 ")
    @Max(value = 100, message = "Введите значение меньше 100 ")
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
