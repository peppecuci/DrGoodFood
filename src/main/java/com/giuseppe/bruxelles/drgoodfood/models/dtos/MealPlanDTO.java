package com.giuseppe.bruxelles.drgoodfood.models.dtos;

import com.giuseppe.bruxelles.drgoodfood.models.entities.Consultation;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Meal;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MealPlanDTO {

    private Long mealPlanId;
    private int carbsPercent;
    private int fatsPercent;
    private int proteinsPercent;
    private int caloriesTotal;
//    TODO private List<Consultation> consultations;
//    TODO private List<Meal> meals;


}
