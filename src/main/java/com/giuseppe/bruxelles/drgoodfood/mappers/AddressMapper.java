package com.giuseppe.bruxelles.drgoodfood.mappers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.AddressDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import com.giuseppe.bruxelles.drgoodfood.models.forms.AddressInsertForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientInsertForm;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public static Address toEntity(AddressInsertForm toInsert) {
        
        if(toInsert == null)
            return null;
        Address address = new Address();
        address.
        
    }

    public AddressDTO toDto(Address entity) {

        if(entity == null)
            return null;

        return AddressDTO.builder().

    }
}
