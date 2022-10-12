package com.giuseppe.bruxelles.drgoodfood.configs.forms;

import com.giuseppe.bruxelles.drgoodfood.configs.entities.UserCustom;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UserCustomCreateForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public UserCustom toEntity(){

        UserCustom userCustom = new UserCustom();
        userCustom.setUsername(username);
        userCustom.setPassword(password);
        userCustom.setRoles(List.of("CLIENT"));
        return userCustom;

    }
}
