package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealPlanDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealPlanForm;
import com.giuseppe.bruxelles.drgoodfood.services.MealPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/mealplan")
@RestController
public class MealPlanController {

    private final MealPlanService service;

    public MealPlanController(MealPlanService service) {
        this.service = service;
    }

    @PostMapping
    public MealPlanDTO toInsert(@RequestBody MealPlanForm form ){

        return service.create(form);

    }

    @GetMapping("{id:[0-9]+}")
    public MealPlanDTO getOne(@PathVariable Long id){

        return service.getOne(id);

    }

    @GetMapping
    public List<MealPlanDTO> getAll(){

        return service.getAll();

    }

    @PatchMapping("{id:[0-9]+}")
    public MealPlanDTO update(@PathVariable Long id, @RequestBody MealPlanForm form){

        return service.update(id, form);

    }

}
