package com.giuseppe.bruxelles.drgoodfood.configs.forms;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String nickname;
    private String image;
    private String countryIso;
    private boolean enabled;
    private List<String> roles;
    private Set<Long> places;
}
