package com.giuseppe.bruxelles.drgoodfood.repositories;

import com.giuseppe.bruxelles.drgoodfood.models.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query("SELECT  c FROM Consultation c WHERE c.client.clientId = ?1 ORDER BY c.dateConsultation DESC")
    Optional<Consultation> findLast(long idClient);

}
