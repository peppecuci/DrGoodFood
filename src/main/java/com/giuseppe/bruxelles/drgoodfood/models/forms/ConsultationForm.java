package com.giuseppe.bruxelles.drgoodfood.models.forms;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ConsultationForm {

    private LocalDate dateConsultation = LocalDate.now();
    private int weight;
    private int waistCirumference;
    private List<String> carbsClientLikes;

}
