package com.giuseppe.bruxelles.drgoodfood.services.impl;

import com.giuseppe.bruxelles.drgoodfood.exceptions.ElementNotFoundException;
import com.giuseppe.bruxelles.drgoodfood.mappers.MealPlanMapper;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealPlanDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.MealPlan;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealPlanConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealPlanForm;
import com.giuseppe.bruxelles.drgoodfood.repositories.ConsultationRepository;
import com.giuseppe.bruxelles.drgoodfood.repositories.MealPlanRepository;
import com.giuseppe.bruxelles.drgoodfood.services.ConsultationService;
import com.giuseppe.bruxelles.drgoodfood.services.MealPlanService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MealPlanServiceImpl implements MealPlanService {
    private final ConsultationService consultationService;

    private final ConsultationRepository consultRepo;

    private final MealPlanRepository repository;

    private final MealPlanMapper mapper;

    public MealPlanServiceImpl(ConsultationService consultationService, ConsultationRepository consultRepo, MealPlanRepository repository, MealPlanMapper mapper) {
        this.consultationService = consultationService;
        this.consultRepo = consultRepo;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MealPlanDTO create(MealPlanForm toInsert, ConsultationForm consultationForm) {

        if(toInsert == null)
            throw new IllegalArgumentException("mealplan -to insert- cannot be null");

        MealPlan mealPlan = mapper.toEntity(toInsert);

        mealPlan.setCaloriesTotal((int) consultationService.dailyMaintenanceCalories(consultationForm));

        return mapper.toDto(repository.save(mealPlan));

    }

    @Override
    public MealPlanDTO create(MealPlanConsultationForm form) {
        return null;
    }

    @Override
    public MealPlanDTO create(MealPlanForm toInsert) {
        return null;
    }

    @Override
    public MealPlanDTO update(Long id, MealPlanForm toUpdate) {

        MealPlan mealPlan = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(MealPlan.class, id));

        if(toUpdate.getCarbsPercent() != null)
            mealPlan.setCarbsPercent(toUpdate.getCarbsPercent());
        if (toUpdate.getFatsPercent() != null)
            mealPlan.setFatsPercent(toUpdate.getFatsPercent());
        if (toUpdate.getProteinsPercent() != null)
            mealPlan.setProteinsPercent(toUpdate.getProteinsPercent());
        if (toUpdate.getProteinsPercent() != null)
            mealPlan.setCaloriesTotal(toUpdate.getCaloriesTotal());

        mealPlan = repository.save(mealPlan);

        return mapper.toDto(mealPlan);    }

    @Override
    public MealPlanDTO readOne(Long id) {

        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(MealPlan.class, id));
    }

    public MealPlanDTO getMostRecentDate(long id){

        return consultRepo.findLast(id)
                .map( consultation -> mapper.toDto(consultation.getMealPlan()) )
                .orElseThrow(() -> new ElementNotFoundException(MealPlan.class, id));

    }

    @Override
    public List<MealPlanDTO> readAll() {

        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
            }

}
