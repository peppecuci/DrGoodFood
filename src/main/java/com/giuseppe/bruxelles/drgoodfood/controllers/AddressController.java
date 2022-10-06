package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.AddressDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.AddressForm;
import com.giuseppe.bruxelles.drgoodfood.services.AddressService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/address")
@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PatchMapping("/{id:[0-9]+}")
    public AddressDTO update(@PathVariable Long id, @RequestBody AddressForm form){

        return addressService.update(id, form);

    }

}
