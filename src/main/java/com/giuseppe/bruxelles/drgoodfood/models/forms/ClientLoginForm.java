package com.giuseppe.bruxelles.drgoodfood.models.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ClientLoginForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
