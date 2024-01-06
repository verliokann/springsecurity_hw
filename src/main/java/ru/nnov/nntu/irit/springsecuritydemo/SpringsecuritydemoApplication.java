package ru.nnov.nntu.irit.springsecuritydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.nnov.nntu.irit.springsecuritydemo.models.ApplicationUser;
import ru.nnov.nntu.irit.springsecuritydemo.models.Role;
import ru.nnov.nntu.irit.springsecuritydemo.repository.RoleRepository;
import ru.nnov.nntu.irit.springsecuritydemo.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringsecuritydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritydemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
        return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			ApplicationUser admin = new ApplicationUser(1,"admin",passwordEncode.encode("password"), roles);
			userRepository.save(admin);
		};
	}
}
