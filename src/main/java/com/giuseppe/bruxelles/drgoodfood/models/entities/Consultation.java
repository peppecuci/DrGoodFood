package com.giuseppe.bruxelles.drgoodfood.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "consultation_id")
    private Long consultationId;

    @Column(nullable = false, name = "date_of_consultation")
    private LocalDate dateConsultation = LocalDate.now();

    @Column(nullable = false, name = "weight")
    private int weight;

    @Column(nullable = false, name = "waist_circumference")
    private int waistCirumference;

    @Column(nullable = false, name = "counter")
    private int counter;

    @ElementCollection
    private List<String> carbsClientLikes;

    @ElementCollection
    private List<String> fatsClientLikes;

    @ElementCollection
    private List<String> proteinsClientLikes;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "meal_plan_id")
    private MealPlan mealPlan;

}
