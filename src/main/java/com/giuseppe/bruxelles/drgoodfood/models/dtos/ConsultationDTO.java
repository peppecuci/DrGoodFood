package com.giuseppe.bruxelles.drgoodfood.models.dtos;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class ConsultationDTO {

    private Long consultationId;
    private LocalDate dateConsultation = LocalDate.now();
    private String sex;
    private int height;
    private int weight;
    private int age;
    private int waistCircumference;
    private String goal;
    private float bmi;
    private String trainPerWeek;
    private int counter;
    private ClientDTO client;
    private MealPlanDTO mealPlan;

}
