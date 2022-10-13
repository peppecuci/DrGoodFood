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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ClientServiceImpl implements UserDetailsService {

    private final ClientRepository repository;
    private final AddressRepository addressRepository;
    private final ClientMapper clientMapper;
    private final PasswordEncoder encoder;

    public ClientServiceImpl(ClientRepository repository, AddressRepository addressRepository, ClientMapper clientMapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.addressRepository = addressRepository;
        this.clientMapper = clientMapper;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Connection not possible."));
    }

    public ClientDTO create(ClientForm toInsert) {
        if(toInsert == null)
            throw new IllegalArgumentException("client -to insert- cannot be null");
        System.out.println(toInsert);
        Client client = clientMapper.toEntity(toInsert);
        client.setPassword(encoder.encode(toInsert.getPassword()));
        addressRepository.save(client.getAddress());
        return clientMapper.toDto(repository.save(client));
    }

    public ClientDTO readOne(Long id) {
        if(id == null)
            throw new IllegalArgumentException("id cannot be null");
        return clientMapper.toDto(repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Client.class, id)));
    }

    public List<ClientDTO> readAll() {
        return repository.findAll().stream()
                .map(clientMapper::toDto)
                .toList();

    }

    public ClientDTO update(Long id, ClientForm toUpdate) {

        Client client = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Client.class, id));

        Address address = new Address();

        if (toUpdate.getUsername() != null)
            client.setUsername(toUpdate.getUsername());
        if(toUpdate.getFirstName() != null)
            client.setFirstName(toUpdate.getFirstName());
        if (toUpdate.getLastName() != null)
            client.setLastName(toUpdate.getLastName());
        if (toUpdate.getMailAddress() != null)
            client.setMailAddress(toUpdate.getMailAddress());
        if (toUpdate.getSex() != null)
            client.setSex(toUpdate.getSex());
       if (toUpdate.getAddress() != null)
           client.setAddress(AddressMapper.toEntity(toUpdate.getAddress()));

        addressRepository.save(client.getAddress());

        client = repository.save(client);

        return clientMapper.toDto(client);

    }


    //THIS FUNCTION DON'T DELETE THE CLIENT BUT IT JUST CHANGE THE isActive VALUE FROM TRUE TO FALSE
    //TODO implement the function to modify the "isActive" value from "Subscription" from True to False
    public void delete(Long id){
        Client client = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Client.class, id));
    }
}
