package ru.nnov.nntu.irit.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nnov.nntu.irit.springsecuritydemo.models.ApplicationUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser,Integer> {
    Optional<ApplicationUser> findByUsername(String username);
}
