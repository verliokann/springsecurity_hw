package ru.nnov.nntu.irit.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nnov.nntu.irit.springsecuritydemo.models.Role;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByAuthority(String authority);
}
