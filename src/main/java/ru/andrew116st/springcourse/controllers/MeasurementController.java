package ru.andrew116st.springcourse.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.andrew116st.springcourse.services.MeasurementService;
import org.springframework.web.bind.annotation.*;
import ru.andrew116st.springcourse.dto.MeasurementDTO;
import ru.andrew116st.springcourse.models.Measurement;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/measurements")

public class MeasurementController {

    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementController (MeasurementService measurementService,
                                  ModelMapper modelMapper) {

        this.measurementService= measurementService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                   BindingResult bindingResult) {

        Measurement measurement = modelMapper.map(measurementDTO, Measurement.class);

        measurementService.save(measurement);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
