package com.giuseppe.bruxelles.drgoodfood.models.dtos;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class ConsultationDTO {

    private Long consultationId;
    private LocalDate dateConsultation = LocalDate.now();
    private int weight;
    private int waistCirumference;
    private int counter;
    private ClientDTO client;
    private MealPlanDTO mealPlan;

}
