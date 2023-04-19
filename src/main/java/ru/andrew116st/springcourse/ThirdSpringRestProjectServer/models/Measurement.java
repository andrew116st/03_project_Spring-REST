package ru.andrew116st.springcourse.FirstRestApp.models;


import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Date;

/**
 * @author andrew116st
 */

@Entity
@Table(name = "Measurements")

public class Measurement {

    @NotNull(message = "Сенсор не идентифицирован")
    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Значение параметра некорректно")
    @Column(name = "raining")
    private Boolean raining;

    @NotNull(message = "Значение температуры не должно быть пустым")
    @Min(value = -100, message = "Введите значение больше -100 ")
    @Max(value = 100, message = "Введите значение меньше 100 ")
    @Column(name = "value")
    private Double value;

    @NotNull(message = "Время измерения не назначено")
    @Column (name= "created_at")
    @Temporal(TemporalType.TIMESTAMP)

    private Date createdAt;


    public Measurement() {

    }

    public Measurement(int id, Boolean raining, Double value, Date createdAt ) {
        this.id = id;
        this.raining = raining;
        this.value = value;
        this.createdAt = createdAt;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}