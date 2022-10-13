package com.giuseppe.bruxelles.drgoodfood.controllers;

import com.giuseppe.bruxelles.drgoodfood.configs.forms.TokenDTO;
import com.giuseppe.bruxelles.drgoodfood.configs.forms.UserCustomCreateForm;
import com.giuseppe.bruxelles.drgoodfood.configs.forms.UserDTO;
import com.giuseppe.bruxelles.drgoodfood.configs.forms.UserLoginForm;
import com.giuseppe.bruxelles.drgoodfood.configs.services.CustomUserDetailsServiceImpl;
import com.giuseppe.bruxelles.drgoodfood.configs.utils.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/user")
public class UserController {
    private final CustomUserDetailsServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public UserController(CustomUserDetailsServiceImpl userService, AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserCustomCreateForm form) {
        userService.create(form);
    }

    @PostMapping("/login")
    public TokenDTO login(@Valid @RequestBody UserLoginForm form){
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        return new TokenDTO(jwtProvider.createToken(auth));
    }

    @GetMapping("/{id:[0-9]+}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public UserDTO readOne(@Valid @PathVariable Long id) {
        return userService.readOne(id);
    }

    @PatchMapping("/update/{id:[0-9]+}")
    @Secured({"ROLE_ADMIN"})
    public UserDTO update(@Valid @PathVariable Long id, @Valid @RequestBody UserCustomCreateForm form) {
        return userService.update(id, form);
    }

}
