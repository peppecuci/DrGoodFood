package com.giuseppe.bruxelles.drgoodfood.models.forms;

import lombok.Data;

@Data
public class AddressForm {

    private Integer num;
    private String street;
    private Integer zipCode;
    private String city;

}
