package com.giuseppe.bruxelles.drgoodfood.models.dtos;

import lombok.Builder;
import lombok.Data;


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
