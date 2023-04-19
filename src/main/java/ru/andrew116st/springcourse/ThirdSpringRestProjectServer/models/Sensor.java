package ru.andrew116st.springcourse.FirstRestApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author andrew116st
 */

@Entity
@Table(name = "Sensors")

public class Sensor {
    @OneToMany (mappedBy = "sensor", fetch = FetchType.LAZY)
    private List<Measurement> measurements;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")

    @Column(name = "name")
    private String name;


    public Sensor() {

    }

    public Sensor(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
