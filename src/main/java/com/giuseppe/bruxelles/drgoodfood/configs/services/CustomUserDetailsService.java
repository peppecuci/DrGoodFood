package com.giuseppe.bruxelles.drgoodfood.configs.services;

import com.giuseppe.bruxelles.drgoodfood.configs.entities.UserCustom;
import com.giuseppe.bruxelles.drgoodfood.configs.forms.UserCustomCreateForm;
import com.giuseppe.bruxelles.drgoodfood.configs.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("impossible to connect"));
    }

    public void create(UserCustomCreateForm toCreate){

        UserCustom userCustom = toCreate.toEntity();
        userCustom.setPassword(passwordEncoder.encode(userCustom.getPassword()));
        userRepository.save(userCustom);


    }

}
