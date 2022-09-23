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
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long ingredientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;  //TODO create an enum class with Carbs / Fats / Proteins / Carbs & Fats / Carbs & Proteins etc

    @Column(nullable = false)
    private int calories;


    @ManyToMany
    @JoinTable(name = "meal_ingredient", joinColumns = @JoinColumn(name = "ingredientId"), inverseJoinColumns = @JoinColumn(name = "mealId"))
    private List<Meal> meals;

}
