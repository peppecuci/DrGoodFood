package com.giuseppe.bruxelles.drgoodfood.services.impl;

import com.giuseppe.bruxelles.drgoodfood.exceptions.ElementNotFoundException;
import com.giuseppe.bruxelles.drgoodfood.mappers.ConsultationMapper;
import com.giuseppe.bruxelles.drgoodfood.mappers.MealPlanMapper;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.ConsultationDTO;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.MealPlanDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Consultation;
import com.giuseppe.bruxelles.drgoodfood.models.entities.MealPlan;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.repositories.ConsultationRepository;
import com.giuseppe.bruxelles.drgoodfood.repositories.MealPlanRepository;
import com.giuseppe.bruxelles.drgoodfood.services.ConsultationService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsultationServiceImpl implements ConsultationService {



    private final MealPlanMapper mealPlanMapper;
    private final MealPlanRepository mealPlanRepository;
    private final ConsultationMapper consultationMapper;
    private final ConsultationRepository repository;

    public ConsultationServiceImpl(MealPlanMapper mealPlanMapper, MealPlanRepository mealPlanRepository, ConsultationMapper consultationMapper, ConsultationRepository repository) {
        this.mealPlanMapper = mealPlanMapper;
        this.mealPlanRepository = mealPlanRepository;
        this.consultationMapper = consultationMapper;
        this.repository = repository;
    }


    @Override
    public ConsultationDTO create(ConsultationForm toInsert) {

        if(toInsert == null)
            throw new IllegalArgumentException("consultation -to insert- cannot be null");

        Consultation consultation = consultationMapper.toEntity(toInsert);

        MealPlan mealplan = new MealPlan();

        if(consultation.getGoal() == null)
            throw new NullPointerException();

        consultation.setBmi((int) bmiCalculation(toInsert));

        switch (consultation.getGoal()) {
            case "lose" -> {
                mealplan.setCaloriesTotal((int) dailyMaintenanceCalories(toInsert) - 550);
                mealplan.setCarbsPercent(45);
                mealplan.setFatsPercent(25);
                mealplan.setProteinsPercent(30);
            }
            case "gain" -> {
                mealplan.setCaloriesTotal((int) dailyMaintenanceCalories(toInsert) + 300);
                mealplan.setCarbsPercent(55);
                mealplan.setFatsPercent(20);
                mealplan.setProteinsPercent(25);
            }
            case "keep" -> {
                mealplan.setCaloriesTotal((int) dailyMaintenanceCalories(toInsert));
                mealplan.setCarbsPercent(40);
                mealplan.setFatsPercent(30);
                mealplan.setProteinsPercent(30);
            }
        }

        consultation.setMealPlan( mealPlanRepository.save(mealplan) );

        return consultationMapper.toDto(repository.save(consultation));

    }


    @Override
    // METHOD NOT NEEDED FOR THE MOMENT
    public ConsultationDTO update(Long id, ConsultationForm toUpdate) {
        return null;
    }

    @Override
    public ConsultationDTO readOne(Long id) {

        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        return repository.findById(id)
                .map(consultationMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Address.class, id));
    }

    @Override
    public List<ConsultationDTO> readAll() {

        return repository.findAll().stream()
                .map(consultationMapper::toDto)
                .toList();

    }

    @Override
    public void delete(Long id) {
    }

    public double dailyMaintenanceCalories(ConsultationForm form) {


        double bmr = -1;

        if(form.getSex().equals("male"))

            bmr = ((66.5 + (13.7 * form.getWeight())) + (5 * form.getHeight()) - (6.8 * form.getAge()));

        else if(form.getSex().equals("female"))

            bmr = (665 + (9.5 * form.getWeight()) + (1.85 * form.getHeight()) - (4.7 * form.getAge()));


            switch (form.getTrainPerWeek()){
                case ("little") -> {
                    bmr += 100;
                }
                case ("medium") -> {
                    bmr += 200;
                }
                case ("lot") -> {
                    bmr += 300;
                }
                case ("always") -> {
                    bmr += 400;
                }
            }

        if( bmr == -1 )
            throw new RuntimeException("tht's the message"); // TODO qu'envoyer?

        return bmr;

    }

    @Override
    public double bmiCalculation(ConsultationForm form) {
        double bmi;

        float result = (float) form.getWeight()/ form.getHeight();
        System.out.println(result);
        System.out.println(result / form.getHeight());

        return bmi = (((float)form.getWeight() / form.getHeight()) / form.getHeight()) *10000;

    }
}
