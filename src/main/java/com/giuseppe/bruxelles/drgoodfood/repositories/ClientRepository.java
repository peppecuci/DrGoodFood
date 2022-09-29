package com.giuseppe.bruxelles.drgoodfood.repositories;

import com.giuseppe.bruxelles.drgoodfood.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
