package ru.andrew116st.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrew116st.springcourse.models.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {


}
