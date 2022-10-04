package com.giuseppe.bruxelles.drgoodfood.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealDTO {

    private Long mealId;
    private int caloriesTotalAmount;
    private int carbsTotalAmount;
    private int fatsTotalAmount;
    private int proteinsTotalAmount;

}
