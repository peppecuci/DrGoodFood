package com.giuseppe.bruxelles.drgoodfood.repositories;

import com.giuseppe.bruxelles.drgoodfood.models.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {

    public Optional<Client> findByUsername(String username);
    public List<Client> findAll();

}
