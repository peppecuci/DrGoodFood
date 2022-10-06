package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ClientDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientForm;
import com.giuseppe.bruxelles.drgoodfood.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/client")
@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //INSERT
    @PostMapping
    public ClientDTO insert(@RequestBody ClientForm form){

        return clientService.create(form);

    }

    //GETONE // http://localhost:8080/client/45
    @GetMapping("/{id:[0-9]+}")
    public ClientDTO getOne(@PathVariable Long id) {

        return clientService.getOne(id);

    }

    @GetMapping
    public List<ClientDTO> getAll(){

        return clientService.getAll();

    }

    @PatchMapping("/{id:[0-9]+}")
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientForm form){

        return clientService.update(id, form);

    }

}
