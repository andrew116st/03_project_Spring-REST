package ru.andrew116st.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andrew116st.springcourse.dto.MeasurementDTO;
import ru.andrew116st.springcourse.models.Measurement;
import ru.andrew116st.springcourse.models.Sensor;
import ru.andrew116st.springcourse.repositories.MeasurementRepository;
import ru.andrew116st.springcourse.repositories.SensorRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)

public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;


    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository,
                              SensorService sensorService) {

        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }


    @Transactional
    public void save(Measurement measurement){
        measurement.setCreatedAt(new Date());
        Sensor sensor = sensorService.findByName(measurement.getSensor().getName());
        measurement.setSensor(sensor);

        measurementRepository.save(measurement);
    }

    @Transactional
    public List<Measurement> findAllMeasurements(){

        return measurementRepository.findAll();


    }



}
