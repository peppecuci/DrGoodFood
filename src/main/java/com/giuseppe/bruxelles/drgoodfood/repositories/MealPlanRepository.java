package com.giuseppe.bruxelles.drgoodfood.repositories;

import com.giuseppe.bruxelles.drgoodfood.models.entities.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {

//    @Query("Select * FROM MealPlan m WHERE m. ORDER BY DATE_ADDED DESC LIMIT 1");
//    MealPlan ggetMostRecentMealplan();

}
