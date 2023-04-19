package ru.andrew116st.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrew116st.springcourse.models.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {


}
