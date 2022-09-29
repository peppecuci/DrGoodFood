package com.giuseppe.bruxelles.drgoodfood.repositories;

import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
