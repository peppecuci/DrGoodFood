package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ClientDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientInsertForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientUpdateForm;
import com.giuseppe.bruxelles.drgoodfood.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/client")
@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //INSERT
    @PostMapping
    public ClientDTO insert(@RequestBody ClientInsertForm form){

        return clientService.create(form);

    }

    //GETONE
    @GetMapping("/{id:[0-9]+}")
    public ClientDTO getOne(@PathVariable Long id) {

        return clientService.getOne(id);

    }

    @GetMapping
    public List<ClientDTO> getAll(){

        return clientService.getAll();

    }

    @PatchMapping("/{id:[0-9]+}")
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientUpdateForm form){

        return clientService.update(id, form);

    }

}
