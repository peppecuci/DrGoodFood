package com.giuseppe.bruxelles.drgoodfood.mappers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ConsultationDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Consultation;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import org.springframework.stereotype.Component;

@Component
public class ConsultationMapper {

    private final ClientMapper clientMapper;
    private final MealPlanMapper mealPlanMapper;

    public ConsultationMapper(ClientMapper clientMapper, MealPlanMapper mealPlanMapper) {
        this.clientMapper = clientMapper;
        this.mealPlanMapper = mealPlanMapper;
    }

    public Consultation toEntity(ConsultationForm form){

        if(form == null)
            return null;

        Consultation consultation = new Consultation();

        consultation.setDateConsultation(form.getDateConsultation());
        consultation.setSex(form.getSex());
        consultation.setHeight(form.getHeight());
        consultation.setWeight(form.getWeight());
        consultation.setAge(form.getAge());
        consultation.setWaistCirumference(form.getWaistCircumference());
        consultation.setGoal(form.getGoal());
        consultation.setTrainPerWeek(form.getTrainPerWeek());

        return consultation;

    }

    public ConsultationDTO toDto(Consultation entity) {


        if(entity == null)
            return null;

        return ConsultationDTO.builder()
                .consultationId(entity.getConsultationId())
                .dateConsultation(entity.getDateConsultation())
                .sex(entity.getSex())
                .height(entity.getHeight())
                .weight(entity.getWeight())
                .age(entity.getAge())
                .waistCircumference(entity.getWaistCirumference())
                .bmi(entity.getBmi())
                .goal(entity.getGoal())
                .trainPerWeek(entity.getTrainPerWeek())
                .client(clientMapper.toDto(entity.getClient()))
                .mealPlan(mealPlanMapper.toDto(entity.getMealPlan()))
                .build();
    }

}
