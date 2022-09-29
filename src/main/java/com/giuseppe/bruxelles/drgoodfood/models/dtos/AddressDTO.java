package com.giuseppe.bruxelles.drgoodfood.models.dtos;

import com.giuseppe.bruxelles.drgoodfood.models.entities.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AddressDTO {

    private Long addressId;
    private int num;
    private String street;
    private int zipCode;
    private String city;
    private List<Client> clients;

}
