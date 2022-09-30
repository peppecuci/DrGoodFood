package com.giuseppe.bruxelles.drgoodfood.mappers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ConsultationDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Consultation;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import org.springframework.stereotype.Component;

@Component
public class ConsultationMapper {

    private final ClientMapper clientMapper;

    public ConsultationMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    public Consultation toEntity(ConsultationForm form){

        if(form == null)
            return null;

        Consultation consultation = new Consultation();

        consultation.setDateConsultation(form.getDateConsultation());
        consultation.setWeight(form.getWeight());
        consultation.setWaistCirumference(form.getWaistCirumference());

        return consultation;

    }

    public ConsultationDTO toDto(Consultation entity) {


        if(entity == null)
            return null;

        return ConsultationDTO.builder()
                .consultationId(entity.getConsultationId())
                .dateConsultation(entity.getDateConsultation())
                .weight(entity.getWeight())
                .waistCirumference(entity.getWaistCirumference())
                .client(clientMapper.toDto(entity.getClient()))
//                TODO .mealPlan(mealPlanMapper.toDto(entity.getMealPlan())
                .build();

    }

}
