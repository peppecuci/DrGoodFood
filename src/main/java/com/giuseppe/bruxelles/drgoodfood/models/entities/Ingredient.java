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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "type")
    private String type;  //TODO create an enum class with Carbs / Fats / Proteins / Carbs & Fats / Carbs & Proteins etc

    @Column(nullable = false, name = "calories")
    private int calories;

    @Column(nullable = false, name = "carbs_percent")
    private int carbsPercent;

    @Column(nullable = false, name = "fats_percent")
    private int fatsPercent;

    @Column(nullable = false, name = "proteins_percent")
    private int proteinsPercent;

    @ManyToMany
    @JoinTable(
            name = "meal_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;

}
