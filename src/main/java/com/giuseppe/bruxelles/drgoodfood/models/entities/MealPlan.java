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
@Table(name = "mealplan")
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealplan_id")
    private Long mealPlanId;

    @Column(nullable = false, name = "carbs_percent")
    private int carbsPercent;

    @Column(nullable = false, name = "fats_percent")
    private int fatsPercent;

    @Column(nullable = false, name = "proteins_percent")
    private int proteinsPercent;

    @Column(nullable = false, name = "calories_total")
    private int caloriesTotal;

    @OneToMany(mappedBy = "mealPlan")
    private List<Consultation> consultations;

    @ManyToMany(mappedBy = "mealPlans")
    private List<Meal> meals;

}
