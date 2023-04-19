package ru.andrew116st.springcourse.FirstRestApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.andrew116st.springcourse.FirstRestApp.dto.SensorDTO;
import ru.andrew116st.springcourse.FirstRestApp.models.Sensor;
import ru.andrew116st.springcourse.FirstRestApp.services.SensorService;

import javax.validation.Valid;
import java.util.List;

@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/sensors")

public class SensorController {

    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper) {

        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                                   BindingResult bindingResult) {

        Sensor sensor = modelMapper.map(sensorDTO, Sensor.class);

        sensorService.save(sensor);

        return ResponseEntity.ok(HttpStatus.OK);
    }


}