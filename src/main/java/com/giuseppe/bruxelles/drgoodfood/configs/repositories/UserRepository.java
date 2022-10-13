package com.giuseppe.bruxelles.drgoodfood.configs.repositories;

import com.giuseppe.bruxelles.drgoodfood.configs.entities.UserCustom;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserCustom, Long> {

    public Optional<UserCustom> findByUsername(String username);

}
