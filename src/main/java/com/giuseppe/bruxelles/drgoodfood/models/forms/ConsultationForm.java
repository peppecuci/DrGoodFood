package com.giuseppe.bruxelles.drgoodfood.models.forms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsultationForm {

    private LocalDate dateConsultation = LocalDate.now();
    private int weight;
    private int waistCirumference;

}
