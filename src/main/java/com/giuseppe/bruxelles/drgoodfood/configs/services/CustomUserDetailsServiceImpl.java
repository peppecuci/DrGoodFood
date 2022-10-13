package com.giuseppe.bruxelles.drgoodfood.configs.services;

import com.giuseppe.bruxelles.drgoodfood.configs.entities.UserCustom;
import com.giuseppe.bruxelles.drgoodfood.configs.forms.UserCustomCreateForm;
import com.giuseppe.bruxelles.drgoodfood.configs.forms.UserDTO;
import com.giuseppe.bruxelles.drgoodfood.configs.repositories.UserRepository;
import com.giuseppe.bruxelles.drgoodfood.exceptions.AlreadyExistsException;
import com.giuseppe.bruxelles.drgoodfood.exceptions.ElementNotFoundException;
import com.giuseppe.bruxelles.drgoodfood.mappers.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public CustomUserDetailsServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Connection not possible."));
    }

    public void create(UserCustomCreateForm form) {
        try {
            UserCustom user = new UserCustom(form.getUsername(), encoder.encode(form.getPassword()));
            userRepository.save(user);
        }
        catch(Exception exception) {
            throw new AlreadyExistsException(form.getUsername(), "username");
        }
    }


    public UserDTO readOne(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Connection not possible.")));
    }

    public UserDTO update(Long id, UserCustomCreateForm form) {
        UserCustom user = userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(User.class, id));

        if (form.getUsername() != null)
            user.setUsername(encoder.encode(form.getPassword()));

        if (form.getPassword() != null)
            user.setPassword(encoder.encode(form.getPassword()));

        try {
            userRepository.save(user);
        }
        catch(Exception exception) {
            throw new AlreadyExistsException(form.getUsername(), "username");
        }

        return userMapper.toDto(user);
    }

}