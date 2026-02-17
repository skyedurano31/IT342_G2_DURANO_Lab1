package com.systemintegration.backend.repository;

import com.systemintegration.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> Username(String username);
    Optional<User> email(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
