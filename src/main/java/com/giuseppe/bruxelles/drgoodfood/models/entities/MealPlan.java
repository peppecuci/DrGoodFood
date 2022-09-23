package com.giuseppe.bruxelles.drgoodfood.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long mealPlanId;

    @Column(nullable = false)
    private int carbsPercent;

    @Column(nullable = false)
    private int fatsPercent;

    @Column(nullable = false)
    private int proteinsPercent;

    @Column(nullable = false)
    private int caloriesTotal;

    @OneToMany(mappedBy = "mealPlan") //done
    private List<Consultation> consultations;

    @ManyToMany
    private List<Meal> meals;

}
