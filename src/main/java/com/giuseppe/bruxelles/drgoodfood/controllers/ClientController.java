package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ClientDTO;
import com.giuseppe.bruxelles.drgoodfood.models.dtos.TokenDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientLoginForm;
import com.giuseppe.bruxelles.drgoodfood.services.impl.ClientServiceImpl;
import com.giuseppe.bruxelles.drgoodfood.utils.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/client")
@RestController
public class ClientController {

    private final ClientServiceImpl clientService;

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public ClientController(ClientServiceImpl clientService, AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.clientService = clientService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    //INSERT
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody ClientForm form) {
        clientService.create(form);
    }

    //LOGIN
    @PostMapping("/login")
    public TokenDTO login(@Valid @RequestBody ClientLoginForm form){
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        return new TokenDTO(jwtProvider.createToken(auth));
    }

    //GETONE // http://localhost:8080/client/45
    @GetMapping("/{id:[0-9]+}")
    public ClientDTO readOne(@PathVariable Long id) {
        return clientService.readOne(id);
    }

    @GetMapping
    public List<ClientDTO> readAll(){
        return clientService.readAll();
    }

    @PatchMapping("/update/{id:[0-9]+}")
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientForm form){
        return clientService.update(id, form);
    }

}
