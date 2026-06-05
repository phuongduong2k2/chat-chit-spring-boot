package com.codewithnolan.chatchitflutter.repositories;

import com.codewithnolan.chatchitflutter.entities.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM users u WHERE u.email=:email")
    Optional<User> findByEmail(@NonNull String email);
}
