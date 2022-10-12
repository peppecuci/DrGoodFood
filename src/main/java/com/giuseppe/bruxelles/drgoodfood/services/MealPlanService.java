package com.giuseppe.bruxelles.drgoodfood.services;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealPlanDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealPlanConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealPlanForm;

public interface MealPlanService extends CRUDService<MealPlanDTO, Long, MealPlanForm>{

    MealPlanDTO create(MealPlanForm toInsert, ConsultationForm consultationForm);

    MealPlanDTO create (MealPlanConsultationForm form);

    MealPlanDTO getMostRecentDate(long idClient);
}
