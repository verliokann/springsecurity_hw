package ru.nnov.nntu.irit.springsecuritydemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nnov.nntu.irit.springsecuritydemo.models.ApplicationUser;
import ru.nnov.nntu.irit.springsecuritydemo.repository.RoleRepository;
import ru.nnov.nntu.irit.springsecuritydemo.repository.UserRepository;
import ru.nnov.nntu.irit.springsecuritydemo.models.Role;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional  // dlya togo chtobi kontrolirovat vipolnenie neskolkih operacii s BD v rezhime tranzakcii
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository; // dlya dostupa k bd, naprimer,  v procese registracii v systeme
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public ApplicationUser registerUser(String username, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new ApplicationUser(0,username,encodedPassword,authorities));
    }

}
