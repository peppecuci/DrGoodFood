package com.giuseppe.bruxelles.drgoodfood.services.impl;

import com.giuseppe.bruxelles.drgoodfood.exceptions.ElementNotFoundException;
import com.giuseppe.bruxelles.drgoodfood.mappers.MealMapper;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Client;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Meal;
import com.giuseppe.bruxelles.drgoodfood.models.forms.MealForm;
import com.giuseppe.bruxelles.drgoodfood.repositories.MealRepository;
import com.giuseppe.bruxelles.drgoodfood.services.MealService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    private final MealMapper mapper;
    private final MealRepository repository;

    public MealServiceImpl(MealMapper mapper, MealRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public MealDTO create(MealForm toInsert) {

        if(toInsert == null)
            throw new IllegalArgumentException("meal -to insert- cannot be null");

        Meal meal = mapper.toEntity(toInsert);

        return mapper.toDto(repository.save(meal));

    }

    @Override
    public MealDTO create(MealForm toInsert, MealForm otherToInsert) {
        return null;
    }

    @Override
    public MealDTO update(Long id, MealForm toUpdate) {
        return null;
    }

    @Override
    public MealDTO getOne(Long id) {

        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Meal.class, id));

    }

    @Override
    public List<MealDTO> getAll() {

        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();

    }

    @Override
    public MealDTO delete(Long id) {
        return null;
    }
}
