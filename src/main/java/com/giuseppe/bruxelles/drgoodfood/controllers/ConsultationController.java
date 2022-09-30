package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.services.ConsultationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/consultation")
@RestController
public class ConsultationController {

    private final ConsultationService service;


    public ConsultationController(ConsultationService service) {
        this.service = service;
    }
}
