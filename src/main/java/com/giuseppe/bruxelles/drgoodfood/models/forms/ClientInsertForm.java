package com.giuseppe.bruxelles.drgoodfood.models.forms;

import com.giuseppe.bruxelles.drgoodfood.enums.Status;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Consultation;
import com.giuseppe.bruxelles.drgoodfood.models.entities.CustomerOrder;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Subscription;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ClientInsertForm {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nickname;
    private String mailAddress;
    private String creditCard;

}
