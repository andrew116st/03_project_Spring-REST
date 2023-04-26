package ru.andrew116st.springcourse.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.andrew116st.springcourse.dto.SensorDTO;
import ru.andrew116st.springcourse.services.MeasurementService;
import org.springframework.web.bind.annotation.*;
import ru.andrew116st.springcourse.dto.MeasurementDTO;
import ru.andrew116st.springcourse.models.Measurement;
import ru.andrew116st.springcourse.services.SensorService;
import ru.andrew116st.springcourse.util.*;

import javax.validation.Valid;
import java.util.List;

@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/measurements")

public class MeasurementController {

    private final MeasurementService measurementService;

    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementController (MeasurementService measurementService,
                                  SensorService sensorService, ModelMapper modelMapper) {

        this.measurementService= measurementService;
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                   BindingResult bindingResult) {

        Measurement measurement = modelMapper.map(measurementDTO, Measurement.class);

        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError error : errors) {

                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new MeasurementNotRegisteredException(errorMsg.toString());

        }

        if (!sensorService.checkSensorExist(measurementDTO.getSensor().getName())) {

            throw new SensorNotFoundException();


        }

        measurementService.save(measurement);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementNotRegisteredException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(SensorNotFoundException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse("Sensor doesn't exist !!!",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);


    }


}
