package com.giuseppe.bruxelles.drgoodfood.models.forms;

import lombok.Data;

import java.time.LocalDate;


@Data
public class ConsultationForm {

    private LocalDate dateConsultation = LocalDate.now();
    private String sex;
    private int height;
    private int weight;
    private int age;
    private int waistCircumference;
    private String goal;
    private String trainPerWeek;

}
