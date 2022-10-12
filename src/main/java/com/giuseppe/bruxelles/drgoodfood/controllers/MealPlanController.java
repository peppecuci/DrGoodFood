package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealPlanDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Consultation;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealPlanConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealPlanForm;
import com.giuseppe.bruxelles.drgoodfood.services.MealPlanService;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/mealplan")
@RestController
public class MealPlanController {

    private final MealPlanService service;

    public MealPlanController(MealPlanService service) {
        this.service = service;
    }

//    @PostMapping
//    public MealPlanDTO toInsert(@RequestBody MealPlanForm mealPlanForm, @RequestBody ConsultationForm consultationForm){
//    public MealPlanDTO toInsert(@RequestBody ConsultationForm form ){
//
//        System.out.println(form);
//        return service.create(form.getMealPlan(), form.getConsultation());
//
//    }

    @GetMapping("{id:[0-9]+}")
    public MealPlanDTO getOne(@PathVariable Long id){

        return service.getOne(id);

    }

    @GetMapping("/most-recent/{id}")
    public MealPlanDTO getMostRecentDate(@PathVariable("id")/* @RequestParam*/long idClient){

        return service.getMostRecentDate(idClient);

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
