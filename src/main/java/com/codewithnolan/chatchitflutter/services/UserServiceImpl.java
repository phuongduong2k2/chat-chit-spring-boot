package com.codewithnolan.chatchitflutter.services;

import com.codewithnolan.chatchitflutter.entities.User;
import com.codewithnolan.chatchitflutter.repositories.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @NonNull private UserRepository userRepository;

    @Override
    public Optional<User> getById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
