package com.giuseppe.bruxelles.drgoodfood.models.forms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientForm {

    private String firstName;
    private String lastName;
    private String nickname;
    private String sex;
    private String mailAddress;
    private String creditCard;
    private AddressForm address;

}
