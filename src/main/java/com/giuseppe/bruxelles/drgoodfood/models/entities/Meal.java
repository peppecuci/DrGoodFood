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
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long mealId;

    @Column(nullable = false)
    private int caloriesTotalAmount;

    @Column(nullable = false)
    private int carbsTotalAmount;

    @Column(nullable = false)
    private int fatsTotalAmount;

    @Column(nullable = false)
    private int proteinsTotalAmount;

    @ManyToMany
    @JoinTable(name = "mealPlan_meal", joinColumns = @JoinColumn(name = "mealId"),
            inverseJoinColumns = @JoinColumn(name = "mealPlanId"))
    private List<MealPlan> mealPlans;

    @ManyToMany
    private List<Ingredient> ingredients;

}
