package com.giuseppe.bruxelles.drgoodfood.services.impl;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ConsultationDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ConsultationForm;
import com.giuseppe.bruxelles.drgoodfood.services.ConsultationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {


    @Override
    public ConsultationDTO create(ConsultationForm toInsert) {
        return null;
    }

    @Override
    public ConsultationDTO update(Long id, ConsultationForm toUpdate) {
        return null;
    }

    @Override
    public ConsultationDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<ConsultationDTO> getAll() {
        return null;
    }

    @Override
    public ConsultationDTO delete(Long id) {
        return null;
    }
}
