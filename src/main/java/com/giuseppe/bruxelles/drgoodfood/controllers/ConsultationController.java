package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ConsultationDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.services.ConsultationService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/consultation")
@RestController
public class ConsultationController {

    private final ConsultationService service;


    public ConsultationController(ConsultationService service) {
        this.service = service;
    }

    @PostMapping
    @Secured({"ROLE_CLIENT"})
    public ConsultationDTO insert(@RequestBody ConsultationForm form) {
        return service.create(form);
    }

    @GetMapping("/{id:[0-9]+}")
    public ConsultationDTO getOne(@PathVariable Long id){

        return service.readOne(id);

    }

    @GetMapping
    public List<ConsultationDTO> getAll(){

        return service.readAll();

    }



}


