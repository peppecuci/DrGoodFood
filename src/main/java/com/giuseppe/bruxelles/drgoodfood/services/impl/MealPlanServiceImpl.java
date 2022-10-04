package com.giuseppe.bruxelles.drgoodfood.services.impl;

import com.giuseppe.bruxelles.drgoodfood.exceptions.ElementNotFoundException;
import com.giuseppe.bruxelles.drgoodfood.mappers.MealPlanMapper;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealPlanDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.MealPlan;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealPlanForm;
import com.giuseppe.bruxelles.drgoodfood.repositories.MealPlanRepository;
import com.giuseppe.bruxelles.drgoodfood.services.MealPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealPlanServiceImpl implements MealPlanService {

    private final MealPlanRepository repository;

    private final MealPlanMapper mapper;

    public MealPlanServiceImpl(MealPlanRepository repository, MealPlanMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MealPlanDTO create(MealPlanForm toInsert) {

        if(toInsert == null)
            throw new IllegalArgumentException("mealplan -to insert- cannot be null");

        MealPlan mealPlan = mapper.toEntity(toInsert);

        return mapper.toDto(repository.save(mealPlan));

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
    public MealPlanDTO getOne(Long id) {

        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(MealPlan.class, id));
    }

    @Override
    public List<MealPlanDTO> getAll() {

        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public MealPlanDTO delete(Long id) {
        return null;
    }
}
