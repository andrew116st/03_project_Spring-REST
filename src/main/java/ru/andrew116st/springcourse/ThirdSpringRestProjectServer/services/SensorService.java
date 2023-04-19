package ru.andrew116st.springcourse.FirstRestApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andrew116st.springcourse.FirstRestApp.models.Sensor;
import ru.andrew116st.springcourse.FirstRestApp.repositories.SensorRepository;

@Service
@Transactional(readOnly = true)

public class SensorService {

    private final SensorRepository sensorRepository;


    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    @Transactional
    public void save(Sensor sensor){
        sensorRepository.save(sensor);

    }

}
