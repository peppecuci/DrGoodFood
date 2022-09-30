package com.giuseppe.bruxelles.drgoodfood.models.dtos;

import com.giuseppe.bruxelles.drgoodfood.enums.Status;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Subscription;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nickname;
    private String mailAddress;
    private String creditCard;
    private AddressDTO address;
    private Status status;
    private boolean isActive;
//  TODO  private List<Consultation> consultations; METTRE dto ET PAS entité
    private Subscription subscription;
//  TODO private List<CustomerOrder> orders; METTRE dto ET PAS entité

}
