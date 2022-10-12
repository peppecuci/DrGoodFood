package com.giuseppe.bruxelles.drgoodfood.services.impl;

import com.giuseppe.bruxelles.drgoodfood.exceptions.ElementNotFoundException;
import com.giuseppe.bruxelles.drgoodfood.mappers.AddressMapper;
import com.giuseppe.bruxelles.drgoodfood.mappers.ClientMapper;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.ClientDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Client;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientForm;
import com.giuseppe.bruxelles.drgoodfood.repositories.AddressRepository;
import com.giuseppe.bruxelles.drgoodfood.repositories.ClientRepository;
import com.giuseppe.bruxelles.drgoodfood.services.ClientService;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final AddressRepository addressRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository repository, AddressRepository addressRepository, ClientMapper clientMapper) {
        this.repository = repository;
        this.addressRepository = addressRepository;
        this.clientMapper = clientMapper;
    }


    @Override
    public ClientDTO create(ClientForm toInsert) {

        if(toInsert == null)
            throw new IllegalArgumentException("client -to insert- cannot be null");

        Client client = clientMapper.toEntity(toInsert);

        addressRepository.save(client.getAddress());



        return clientMapper.toDto(repository.save(client));

    }

    @Override
    public ClientDTO create(ClientForm toInsert, ClientForm otherToInsert) {
        return null;
    }


    @Override
    public ClientDTO update(Long id, ClientForm toUpdate) {

        Client client = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Client.class, id));

        Address address = new Address();

        if(toUpdate.getFirstName() != null)
            client.setFirstName(toUpdate.getFirstName());
        if (toUpdate.getLastName() != null)
            client.setLastName(toUpdate.getLastName());
        if (toUpdate.getNickname() != null)
            client.setNickname(toUpdate.getNickname());
        if (toUpdate.getMailAddress() != null)
            client.setMailAddress(toUpdate.getMailAddress());
        if (toUpdate.getCreditCard() != null)
            client.setCreditCard(toUpdate.getCreditCard());
       if (toUpdate.getAddress() != null)
           client.setAddress(AddressMapper.toEntity(toUpdate.getAddress()));

        addressRepository.save(client.getAddress());

        client = repository.save(client);

        return clientMapper.toDto(client);

    }

    @Override
    public ClientDTO getOne(Long id) {

        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        return repository.findById(id)
                .map(clientMapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Client.class, id));

    }

    @Override
    public List<ClientDTO> getAll() {

        return repository.findAll().stream()
                .map(clientMapper::toDto)
                .toList();

    }

    @Override //THIS FUNCTION DON'T DELETE THE CLIENT BUT IT JUST CHANGE THE isActive VALUE FROM TRUE TO FALSE
    //TODO implement the function to modify the "isActive" value from "Subscription" from True to False
    public ClientDTO delete(Long id){

        Client client = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Client.class, id));

        return ClientDTO.builder().build();
    }

}
