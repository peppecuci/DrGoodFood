package com.giuseppe.bruxelles.drgoodfood.services;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.AddressDTO;

import com.giuseppe.bruxelles.drgoodfood.models.forms.AddressInsertForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.AddressUpdateForm;


public interface AddressService extends CRUDService<AddressDTO, Long, AddressInsertForm, AddressUpdateForm>{
}
