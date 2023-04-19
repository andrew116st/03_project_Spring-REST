package ru.andrew116st.springcourse.FirstRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrew116st.springcourse.FirstRestApp.models.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {


}
