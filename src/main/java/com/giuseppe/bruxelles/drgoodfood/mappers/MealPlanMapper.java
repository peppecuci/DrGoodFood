package com.giuseppe.bruxelles.drgoodfood.mappers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealPlanDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.MealPlan;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealPlanForm;
import com.giuseppe.bruxelles.drgoodfood.services.ConsultationService;
import org.springframework.stereotype.Component;

@Component
public class MealPlanMapper {

    public MealPlan toEntity(MealPlanForm form){

        if(form == null)
            return null;

        MealPlan mealPlan = new MealPlan();

        ConsultationForm consultationForm = new ConsultationForm();

        mealPlan.setCarbsPercent(form.getCarbsPercent());
        mealPlan.setFatsPercent(form.getFatsPercent());
        mealPlan.setProteinsPercent(form.getProteinsPercent());

        return mealPlan;

    }

    public MealPlanDTO toDto(MealPlan entity) {

        if(entity == null)
            return null;

        return MealPlanDTO.builder()
                .mealPlanId(entity.getMealPlanId())
                .carbsPercent(entity.getCarbsPercent())
                .fatsPercent(entity.getFatsPercent())
                .proteinsPercent(entity.getProteinsPercent())
                .caloriesTotal(entity.getCaloriesTotal())
                .build();

    }

}
