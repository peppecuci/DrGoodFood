package com.giuseppe.bruxelles.drgoodfood.models.dtos;

import com.giuseppe.bruxelles.drgoodfood.enums.Status;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Consultation;
import com.giuseppe.bruxelles.drgoodfood.models.entities.CustomerOrder;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Subscription;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
    private Address address;
    private Status status;
    private List<Consultation> consultations;
    private Subscription subscription;
    private List<CustomerOrder> orders;

}
