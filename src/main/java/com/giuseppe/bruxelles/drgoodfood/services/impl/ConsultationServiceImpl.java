package com.giuseppe.bruxelles.drgoodfood.services.impl;

import com.giuseppe.bruxelles.drgoodfood.exceptions.ElementNotFoundException;
import com.giuseppe.bruxelles.drgoodfood.mappers.ConsultationMapper;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.ConsultationDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Consultation;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.repositories.ClientRepository;
import com.giuseppe.bruxelles.drgoodfood.repositories.ConsultationRepository;
import com.giuseppe.bruxelles.drgoodfood.services.ConsultationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationMapper consultationMapper;
    private final ConsultationRepository repository;
    private final ClientRepository clientRepository;

    public ConsultationServiceImpl(ConsultationMapper consultationMapper, ConsultationRepository repository, ClientRepository clientRepository) {
        this.consultationMapper = consultationMapper;
        this.repository = repository;
        this.clientRepository = clientRepository;
    }


    @Override
    public ConsultationDTO create(ConsultationForm toInsert) {

        if(toInsert == null)
            throw new IllegalArgumentException("consultation -to insert- cannot be null");

        Consultation consultation = consultationMapper.toEntity(toInsert);

//        TODO clientRepository.save(consultation.getClient());
//        TODO mealplan.save(consultation.getMealPlan()); or something like that

        return consultationMapper.toDto(repository.save(consultation));

    }

    @Override
    // METHOD NOT NEEDED FOR THE MOMENT
    public ConsultationDTO update(Long id, ConsultationForm toUpdate) {
        return null;
    }

    @Override
    public ConsultationDTO getOne(Long id) {

        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        return repository.findById(id)
                .map(consultationMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Address.class, id));
    }

    @Override
    public List<ConsultationDTO> getAll() {

        return repository.findAll().stream()
                .map(consultationMapper::toDto)
                .toList();

    }

    @Override
    public ConsultationDTO delete(Long id) {
        return null;
    }
}
