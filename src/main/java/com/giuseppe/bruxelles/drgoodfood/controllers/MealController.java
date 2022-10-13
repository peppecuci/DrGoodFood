package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealForm;
import com.giuseppe.bruxelles.drgoodfood.services.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/meal")
@RestController
public class MealController {

    private final MealService service;

    public MealController(MealService service) {
        this.service = service;
    }

    @PostMapping
    public MealDTO insert(@RequestBody MealForm form){

        return service.create(form);

    }

    @GetMapping("/{id:[0-9]+}")
    public MealDTO getOne(@PathVariable Long id) {

        return service.readOne(id);

    }

    @GetMapping
    public List<MealDTO> getAll(){

        return service.readAll();

    }

}
