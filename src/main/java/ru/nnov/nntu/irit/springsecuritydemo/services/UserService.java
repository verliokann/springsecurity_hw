package ru.nnov.nntu.irit.springsecuritydemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nnov.nntu.irit.springsecuritydemo.models.ApplicationUser;
import ru.nnov.nntu.irit.springsecuritydemo.models.Role;
import ru.nnov.nntu.irit.springsecuritydemo.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

// kak mi hotim, chtobi systema iskala polzovatela vo vremya autentifikacii
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Выполняется сервис сбора информации о пользователе");

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Пользователь не прошел проверку"));
    }
}
