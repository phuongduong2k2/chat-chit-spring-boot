package com.codewithnolan.chatchitflutter.services;

import com.codewithnolan.chatchitflutter.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> getById(UUID uuid);

    Optional<User> getByUsername(String username);

    Optional<User> getByEmail(String email);

    void save(User user);
}
