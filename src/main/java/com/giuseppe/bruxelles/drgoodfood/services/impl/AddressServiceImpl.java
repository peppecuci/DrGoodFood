package com.giuseppe.bruxelles.drgoodfood.services.impl;

import com.giuseppe.bruxelles.drgoodfood.exceptions.ElementNotFoundException;
import com.giuseppe.bruxelles.drgoodfood.mappers.AddressMapper;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.AddressDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import com.giuseppe.bruxelles.drgoodfood.models.forms.AddressForm;
import com.giuseppe.bruxelles.drgoodfood.repositories.AddressRepository;
import com.giuseppe.bruxelles.drgoodfood.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    public AddressServiceImpl(AddressRepository repository, AddressMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AddressDTO create(AddressForm toInsert) {

        if(toInsert == null)
            throw new IllegalArgumentException("address -to insert- cannot be null");

        Address address = AddressMapper.toEntity(toInsert);

        return mapper.toDto(repository.save(address));
    }

    @Override
    public AddressDTO update(Long id, AddressForm toUpdate) {

        Address address = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Address.class, id));

        if(toUpdate.getNum() != null)
            address.setNum(toUpdate.getNum());
        if (toUpdate.getStreet() != null)
            address.setStreet(toUpdate.getStreet());
        if (toUpdate.getZipCode() != null)
            address.setZipCode(toUpdate.getZipCode());
        if (toUpdate.getCity() != null)
            address.setCity(toUpdate.getCity());

        address = repository.save(address);
        return mapper.toDto(address);

    }

    @Override
    public AddressDTO getOne(Long id) {

        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Address.class, id));

    }

    @Override
    public List<AddressDTO> getAll() {

        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();

    }

    @Override
    public AddressDTO delete(Long id){

        Address address = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Address.class, id));

        repository.delete(address);
        address.setAddressId(null);

        return mapper.toDto(address);
    }

}
