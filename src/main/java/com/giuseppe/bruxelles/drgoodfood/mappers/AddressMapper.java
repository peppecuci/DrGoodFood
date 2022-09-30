package com.giuseppe.bruxelles.drgoodfood.mappers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.AddressDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import com.giuseppe.bruxelles.drgoodfood.models.forms.AddressForm;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public static Address toEntity(AddressForm form) {

        if(form == null)
            return null;

        Address address = new Address();
        address.setNum(form.getNum());
        address.setStreet(form.getStreet());
        address.setZipCode(form.getZipCode());
        address.setCity(form.getCity());

        return address;

    }

    public AddressDTO toDto(Address entity) {

        if(entity == null)
            return null;

        return AddressDTO.builder()
                .num(entity.getNum())
                .street(entity.getStreet())
                .zipCode(entity.getZipCode())
                .city(entity.getCity())
                .build();

    }
}
