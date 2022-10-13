package com.giuseppe.bruxelles.drgoodfood.mappers;

import com.giuseppe.bruxelles.drgoodfood.configs.entities.UserCustom;
import com.giuseppe.bruxelles.drgoodfood.configs.forms.UserCustomCreateForm;
import com.giuseppe.bruxelles.drgoodfood.configs.forms.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO toDto(UserCustom entity) {
        if (entity == null)
            return null;
        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .enabled(entity.isEnabled())
                .roles(entity.getRoles())
                .build();
    }

    public UserCustom toEntity(UserCustomCreateForm form) {
        UserCustom user = new UserCustom();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        return user;
    }

}