package com.giuseppe.bruxelles.drgoodfood.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private LocalDate dateConsultation = LocalDate.now();

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    private int waistCirumference;

    @Column(nullable = false)
    private int counter;

    @ManyToOne
    private Client client;

    @ManyToOne
    private MealPlan mealPlan;

}
