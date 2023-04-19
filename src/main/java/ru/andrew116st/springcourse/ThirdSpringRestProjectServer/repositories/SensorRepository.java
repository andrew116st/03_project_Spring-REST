package ru.andrew116st.springcourse.FirstRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrew116st.springcourse.FirstRestApp.models.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {


}
