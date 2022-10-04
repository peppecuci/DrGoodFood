package com.giuseppe.bruxelles.drgoodfood.mappers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ClientDTO;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Client;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Meal;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealForm;
import org.springframework.stereotype.Component;

@Component
public class MealMapper {

    public Meal toEntity(MealForm form){

        if(form == null)
            return null;

        Meal meal = new Meal();

        meal.setCaloriesTotalAmount(form.getCaloriesTotalAmount());
        meal.setCarbsTotalAmount(form.getCarbsTotalAmount());
        meal.setFatsTotalAmount(form.getFatsTotalAmount());
        meal.setProteinsTotalAmount(form.getProteinsTotalAmount());

        return meal;

    }


    public MealDTO toDto(Meal entity) {


        if(entity == null)
            return null;

        return MealDTO.builder()
                .mealId(entity.getMealId())
                .caloriesTotalAmount(entity.getCaloriesTotalAmount())
                .carbsTotalAmount(entity.getCarbsTotalAmount())
                .fatsTotalAmount(entity.getFatsTotalAmount())
                .proteinsTotalAmount(entity.getProteinsTotalAmount())
                .build();

    }
}
