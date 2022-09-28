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
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long mealId;

    @Column(nullable = false, name = "calories_total_amount")
    private int caloriesTotalAmount;

    @Column(nullable = false, name = "carbs_total_amount")
    private int carbsTotalAmount;

    @Column(nullable = false, name = "fats_total_amount")
    private int fatsTotalAmount;

    @Column(nullable = false, name = "proteins_total_amount")
    private int proteinsTotalAmount;

    @ManyToMany
    @JoinTable(name = "meal_plan_meal", joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "mealplan_id"))
    private List<MealPlan> mealPlans;

    @ManyToMany
    @JoinTable(
            name = "meal_ingredient",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;

}
