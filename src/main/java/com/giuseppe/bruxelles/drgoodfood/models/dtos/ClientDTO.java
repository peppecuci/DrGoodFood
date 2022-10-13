package com.giuseppe.bruxelles.drgoodfood.models.dtos;

import com.giuseppe.bruxelles.drgoodfood.enums.Status;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Subscription;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ClientDTO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String sex;
    private String mailAddress;
    private String creditCard;
    private AddressDTO address;
    private Status status;
    private boolean enabled;
    private List<String> roles;
//  TODO  private List<Consultation> consultations; METTRE dto ET PAS entité
    private Subscription subscription;
//  TODO private List<CustomerOrder> orders; METTRE dto ET PAS entité

}
