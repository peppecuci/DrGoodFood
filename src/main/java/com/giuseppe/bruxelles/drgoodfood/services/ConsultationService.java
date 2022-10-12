package com.giuseppe.bruxelles.drgoodfood.services;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ConsultationDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;

public interface ConsultationService extends CRUDService<ConsultationDTO, Long, ConsultationForm>{

    public double dailyMaintenanceCalories(ConsultationForm form);
    public double bmiCalculation(ConsultationForm form);

}
